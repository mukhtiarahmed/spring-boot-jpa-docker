package com.siroi.assignment.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@Entity(name = "MF11_M_COMPMAST")
public class CompanyMaster extends BaseEntity {

  private static final long serialVersionUID = 9052908123617887381L;

  @Id
  @Column(name = "mf11_compCode",length = 3)
  private String compCode;

  @Column(name = "mf11_compCodeHRIS", length = 3)
  private String compCodeHRIS;

  @Column(name = "mf11_compName", length = 70)
  private String companyName;

  @Column(name = "mf11_compAbbrName", length = 15)
  private String companyAbbrName;

  @Column(name = "mf11_compRegNo", length = 20)
  private String compRegNo;

  @Column(name = "mf11_compLogo")
  private String companyLogo;


  /**
   * Override the equals method.
   * @param target the target
   * @return true if two entities have the same ID
   */
  @Override
  public boolean equals(Object target) {
    if(target == null || this.getCompCode() == null)
      return false;

    if (target.getClass() == CompanyMaster.class) {
      CompanyMaster entity = (CompanyMaster) target;
      return this.getCompCode().equals(entity.getCompCode());
    } else {
      return false;
    }

  }

}
