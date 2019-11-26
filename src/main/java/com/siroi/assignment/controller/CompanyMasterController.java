package com.siroi.assignment.controller;

import com.siroi.assignment.annotations.LogMethod;
import com.siroi.assignment.domain.CompanyMaster;
import com.siroi.assignment.dto.ListResponseDTO;
import com.siroi.assignment.dto.SearchCriteria;
import com.siroi.assignment.exception.ConfigurationException;
import com.siroi.assignment.exception.SiroiAssignmentException;
import com.siroi.assignment.form.CompanyMasterForm;
import com.siroi.assignment.mapper.CompanyMasterMapper;
import com.siroi.assignment.service.CompanyService;
import com.siroi.assignment.util.SiroiAssignmentHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.siroi.assignment.util.SiroiAssignmentHelper.checkConfigNotNull;

@Slf4j
@Controller
@RequestMapping("/company")
public class CompanyMasterController {

	@Autowired
	private CompanyService companyService;


	@Value("${image.dir}")
	private String imageDir;


	@PostConstruct
	public void init() {
		checkConfigNotNull(companyService, "companyService");
		if(!SiroiAssignmentHelper.createDirectoryIfNotExist(new File(imageDir))) {
			throw new ConfigurationException("Error during to create dir : " + imageDir);
		}
	}

	/**
	 * Company Listing
	 *
	 * @return String view name
	 */
	@GetMapping("/list")
    @LogMethod
	public String company(ModelMap model,
						  @RequestParam(value ="pageId", defaultValue = "0", required = false)  int pageId,
						  @RequestParam(value = "searchString", required = false, defaultValue = "") String searchString) {

		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setPage(pageId);
		searchCriteria.setSearchString(searchString);

		ListResponseDTO<CompanyMaster> listResponse =  companyService.list(searchCriteria);
		model.addAttribute("listResponse", listResponse);
		model.addAttribute("searchCriteria", searchCriteria);
		return "company";
	}

	/**
	 * Company Listing
	 *
	 * @return String view name
	 */
	@PostMapping("/list")
    @LogMethod
	public String companySearch(@ModelAttribute SearchCriteria searchCriteria, ModelMap model) {


		ListResponseDTO<CompanyMaster> listResponse =  companyService.list(searchCriteria);
		model.addAttribute("listResponse", listResponse);
		model.addAttribute("searchCriteria", searchCriteria);
		return "companyTable";
	}

	/**
	 * Company View
	 *
	 * @return String view name
	 */
	@GetMapping("/view/{compCode}")
    @LogMethod
	public String viewCompany(@PathVariable("compCode") String compCode, ModelMap model)
			throws SiroiAssignmentException {
		CompanyMaster companyMaster = companyService.get(compCode);
		model.addAttribute("company", companyMaster);
		return "viewCompany";
	}

	/**
	 * Add Company View
	 *
	 * @return String view name
	 */
	@GetMapping("/add")
    @LogMethod
	public String viewAddCompany(ModelMap model) {
		CompanyMasterForm form =new CompanyMasterForm();
		form.setActiveDate(SiroiAssignmentHelper.convertActiveDate(LocalDateTime.now()));
		model.addAttribute("company", form );
		return "addCompany";
	}

	/**
	 * Add Company View
	 *
	 * @return String view name
	 */
	@PostMapping("/add")
    @LogMethod
	public String addCompany(@Valid @ModelAttribute("company") CompanyMasterForm form,
							 BindingResult bindingResult,  RedirectAttributes redirectAttributes) throws SiroiAssignmentException {


		if(bindingResult.hasErrors()) {
			return "addCompany";
		}

		Optional <CompanyMaster>  optional = companyService.getRepository().findById(form.getCompCode());

		if(optional.isPresent()) {
			bindingResult.rejectValue("compCode", "compCode.required", "Company Code already exits");
			return "addCompany";
		}

		if(!form.getLogoFile().isEmpty()) {
			form.setCompanyLogo(SiroiAssignmentHelper.copyFileToDir(
					form.getLogoFile(), imageDir + File.separator +  form.getCompCode()));
		}

		CompanyMaster companyMaster = CompanyMasterMapper.toCompanyMaster(form);
		try {
			LocalDateTime localDateTime = SiroiAssignmentHelper.convertToLocalDateTime(form.getActiveDate());
			companyMaster.setActiveDate(localDateTime);
			companyMaster.setIsActive(Boolean.TRUE);
		}catch (ParseException e) {
			log.warn(e.getMessage());
			return "addCompany";
		}

		companyService.create(companyMaster);
		redirectAttributes.addAttribute(SiroiAssignmentHelper.SUCCESS, "Add Company Successfully");
		return "redirect:/company/list";

	}

	/**
	 * Company View
	 *
	 * @return String view name
	 */
	@GetMapping("/edit/{compCode}")
    @LogMethod
	public String editCompany(@PathVariable("compCode") String compCode, ModelMap model)
			throws SiroiAssignmentException {
		CompanyMaster companyMaster = companyService.get(compCode);
		model.addAttribute("company", CompanyMasterMapper.toCompanyMasterFrom(companyMaster));
		return "editCompany";
	}

	/**
	 * Company View
	 *
	 * @return String view name
	 */
	@PostMapping("/update/{compCode}")
    @LogMethod
	public String updateCompany(@PathVariable("compCode") String compCode,
								@Valid @ModelAttribute("company") CompanyMasterForm form,
								BindingResult bindingResult,  RedirectAttributes redirectAttributes)
			throws SiroiAssignmentException {
		boolean hasErrors = bindingResult.hasErrors();
		if(hasErrors) {
			return "editCompany";
		}

		if(!form.getLogoFile().isEmpty()) {
			form.setCompanyLogo(SiroiAssignmentHelper.copyFileToDir(
					form.getLogoFile(), imageDir));
		}

		CompanyMaster companyMaster = CompanyMasterMapper.toCompanyMaster(form);
		companyService.update(compCode, companyMaster);
		redirectAttributes.addAttribute(SiroiAssignmentHelper.SUCCESS, "Update Company Successfully");
		return "redirect:/company/list";
	}

	/**
	 * Company View
	 *
	 * @return String view name
	 */
	@GetMapping("/delete/{compCode}")
    @LogMethod
	public String deleteCompany(@PathVariable("compCode") String compCode, ModelMap model,
								RedirectAttributes redirectAttributes)
			throws SiroiAssignmentException {
		CompanyMaster companyMaster = companyService.get(compCode);
		companyService.delete(companyMaster.getCompCode());
		redirectAttributes.addAttribute(SiroiAssignmentHelper.SUCCESS, "Delete Company Successfully");
		return "redirect:/company/list";
	}

	@GetMapping("/logo/{compCode}/{logoFile}")
	public void companyLogo(@PathVariable("compCode") String compCode,
							@PathVariable("logoFile") String logoFile, HttpServletRequest request,
							HttpServletResponse response) throws IOException {

		ServletContext servletContext = request.getServletContext();
		String filename =  imageDir + File.separator + compCode + File.separator + logoFile;
        File file = new File(filename);
        if(!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

		String mime = servletContext.getMimeType(filename);
		if (mime == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		response.setContentType(mime);

		FileInputStream in = new FileInputStream(file);
        IOUtils.copy(in, response.getOutputStream());


	}
}

