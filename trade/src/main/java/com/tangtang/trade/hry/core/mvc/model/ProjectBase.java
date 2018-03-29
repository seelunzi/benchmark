/*     */
package com.tangtang.trade.hry.core.mvc.model;
/*     */
/*     */

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
@MappedSuperclass
/*     */ public class ProjectBase
        /*     */ extends BaseModel
        /*     */ {
    /*     */   protected BigDecimal projectMoney;
    /*     */   protected Date startDate;
    /*     */   protected Date intentDate;
    /*     */   protected Integer payintentPeriod;
    /*     */   protected String repaymentDate;
    /*     */   protected Integer payintentPerioDate;
    /*     */   protected String repaymentMethod;
    /*     */   protected String repaymentCycle;
    /*     */   protected Integer dayOfEveryPeriod;
    /*     */   protected String ccalculateFirstAndEnd;
    /*     */   protected String interestByOneTime;
    /*     */   protected String preposePayAccrual;
    /*     */   protected String dateModel;
    /*     */   protected String intentDateType;
    /*     */   protected String serviceMoneyWay;
    /*     */   protected String consultationMoneyWay;
    /*     */   protected String otherOneFundMoneyWay;
    /*     */   protected String otherTwoFundMoneyWay;
    /*     */   protected String otherTreeFundMoneyWay;
    /*     */   protected BigDecimal loanInterestMoneyMonthRate;
    /*     */   protected BigDecimal serviceMoneyMonthRate;
    /*     */   protected BigDecimal consultationMoneyMonthRate;
    /*     */   protected BigDecimal otherOneFundMoneyMonthRate;
    /*     */   protected BigDecimal otherTwoFundMoneyMonthRate;
    /*     */   protected BigDecimal otherTreeFundMoneyMonthRate;
    /*     */   protected BigDecimal loanInterestMoneyDayRate;
    /*     */   protected BigDecimal serviceMoneyDayRate;
    /*     */   protected BigDecimal consultationMoneyDayRate;
    /*     */   protected BigDecimal otherOneFundMoneyDayRate;
    /*     */   protected BigDecimal otherTwoFundMoneyDayRate;
    /*     */   protected BigDecimal otherTreeFundMoneyDayRate;
    /*     */   protected BigDecimal loanInterestMoneyYearRate;
    /*     */   protected BigDecimal serviceMoneyYearRate;
    /*     */   protected BigDecimal consultationMoneyYearRate;
    /*     */   protected BigDecimal otherOneFundMoneyYearRate;
    /*     */   protected BigDecimal otherTwoFundMoneyYearRate;
    /*     */   protected BigDecimal otherTreeFundMoneyYearRate;

    /*     */
    /*     */
    public Date getStartDate()
    /*     */ {
        /*  73 */
        return this.startDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getLoanInterestMoneyDayRate()
    /*     */ {
        /*  80 */
        return this.loanInterestMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setLoanInterestMoneyDayRate(BigDecimal loanInterestMoneyDayRate)
    /*     */ {
        /*  87 */
        this.loanInterestMoneyDayRate = loanInterestMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getServiceMoneyDayRate()
    /*     */ {
        /*  94 */
        return this.serviceMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setServiceMoneyDayRate(BigDecimal serviceMoneyDayRate)
    /*     */ {
        /* 101 */
        this.serviceMoneyDayRate = serviceMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getConsultationMoneyDayRate()
    /*     */ {
        /* 108 */
        return this.consultationMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setConsultationMoneyDayRate(BigDecimal consultationMoneyDayRate)
    /*     */ {
        /* 115 */
        this.consultationMoneyDayRate = consultationMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherOneFundMoneyDayRate()
    /*     */ {
        /* 122 */
        return this.otherOneFundMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherOneFundMoneyDayRate(BigDecimal otherOneFundMoneyDayRate)
    /*     */ {
        /* 129 */
        this.otherOneFundMoneyDayRate = otherOneFundMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherTwoFundMoneyDayRate()
    /*     */ {
        /* 136 */
        return this.otherTwoFundMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTwoFundMoneyDayRate(BigDecimal otherTwoFundMoneyDayRate)
    /*     */ {
        /* 143 */
        this.otherTwoFundMoneyDayRate = otherTwoFundMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherTreeFundMoneyDayRate()
    /*     */ {
        /* 150 */
        return this.otherTreeFundMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTreeFundMoneyDayRate(BigDecimal otherTreeFundMoneyDayRate)
    /*     */ {
        /* 157 */
        this.otherTreeFundMoneyDayRate = otherTreeFundMoneyDayRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getLoanInterestMoneyYearRate()
    /*     */ {
        /* 164 */
        return this.loanInterestMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setLoanInterestMoneyYearRate(BigDecimal loanInterestMoneyYearRate)
    /*     */ {
        /* 171 */
        this.loanInterestMoneyYearRate = loanInterestMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getServiceMoneyYearRate()
    /*     */ {
        /* 178 */
        return this.serviceMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setServiceMoneyYearRate(BigDecimal serviceMoneyYearRate)
    /*     */ {
        /* 185 */
        this.serviceMoneyYearRate = serviceMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getConsultationMoneyYearRate()
    /*     */ {
        /* 192 */
        return this.consultationMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setConsultationMoneyYearRate(BigDecimal consultationMoneyYearRate)
    /*     */ {
        /* 199 */
        this.consultationMoneyYearRate = consultationMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherOneFundMoneyYearRate()
    /*     */ {
        /* 206 */
        return this.otherOneFundMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherOneFundMoneyYearRate(BigDecimal otherOneFundMoneyYearRate)
    /*     */ {
        /* 213 */
        this.otherOneFundMoneyYearRate = otherOneFundMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherTwoFundMoneyYearRate()
    /*     */ {
        /* 220 */
        return this.otherTwoFundMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTwoFundMoneyYearRate(BigDecimal otherTwoFundMoneyYearRate)
    /*     */ {
        /* 227 */
        this.otherTwoFundMoneyYearRate = otherTwoFundMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherTreeFundMoneyYearRate()
    /*     */ {
        /* 234 */
        return this.otherTreeFundMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTreeFundMoneyYearRate(BigDecimal otherTreeFundMoneyYearRate)
    /*     */ {
        /* 241 */
        this.otherTreeFundMoneyYearRate = otherTreeFundMoneyYearRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getIntentDateType()
    /*     */ {
        /* 248 */
        return this.intentDateType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIntentDateType(String intentDateType)
    /*     */ {
        /* 255 */
        this.intentDateType = intentDateType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getProjectMoney()
    /*     */ {
        /* 262 */
        return this.projectMoney;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setProjectMoney(BigDecimal projectMoney)
    /*     */ {
        /* 269 */
        this.projectMoney = projectMoney;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setStartDate(Date startDate)
    /*     */ {
        /* 276 */
        this.startDate = startDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Date getIntentDate()
    /*     */ {
        /* 283 */
        return this.intentDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIntentDate(Date intentDate)
    /*     */ {
        /* 290 */
        this.intentDate = intentDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getPayintentPeriod()
    /*     */ {
        /* 297 */
        return this.payintentPeriod;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPayintentPeriod(Integer payintentPeriod)
    /*     */ {
        /* 304 */
        this.payintentPeriod = payintentPeriod;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRepaymentDate()
    /*     */ {
        /* 311 */
        return this.repaymentDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRepaymentDate(String repaymentDate)
    /*     */ {
        /* 318 */
        this.repaymentDate = repaymentDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getPayintentPerioDate()
    /*     */ {
        /* 325 */
        return this.payintentPerioDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPayintentPerioDate(Integer payintentPerioDate)
    /*     */ {
        /* 332 */
        this.payintentPerioDate = payintentPerioDate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRepaymentMethod()
    /*     */ {
        /* 339 */
        return this.repaymentMethod;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRepaymentMethod(String repaymentMethod)
    /*     */ {
        /* 346 */
        this.repaymentMethod = repaymentMethod;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRepaymentCycle()
    /*     */ {
        /* 353 */
        return this.repaymentCycle;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRepaymentCycle(String repaymentCycle)
    /*     */ {
        /* 360 */
        this.repaymentCycle = repaymentCycle;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getDayOfEveryPeriod()
    /*     */ {
        /* 367 */
        return this.dayOfEveryPeriod;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setDayOfEveryPeriod(Integer dayOfEveryPeriod)
    /*     */ {
        /* 374 */
        this.dayOfEveryPeriod = dayOfEveryPeriod;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getCcalculateFirstAndEnd()
    /*     */ {
        /* 381 */
        return this.ccalculateFirstAndEnd;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCcalculateFirstAndEnd(String ccalculateFirstAndEnd)
    /*     */ {
        /* 388 */
        this.ccalculateFirstAndEnd = ccalculateFirstAndEnd;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getInterestByOneTime()
    /*     */ {
        /* 395 */
        return this.interestByOneTime;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setInterestByOneTime(String interestByOneTime)
    /*     */ {
        /* 402 */
        this.interestByOneTime = interestByOneTime;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getPreposePayAccrual()
    /*     */ {
        /* 409 */
        return this.preposePayAccrual;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPreposePayAccrual(String preposePayAccrual)
    /*     */ {
        /* 416 */
        this.preposePayAccrual = preposePayAccrual;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getDateModel()
    /*     */ {
        /* 423 */
        return this.dateModel;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setDateModel(String dateModel)
    /*     */ {
        /* 430 */
        this.dateModel = dateModel;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getLoanInterestMoneyMonthRate()
    /*     */ {
        /* 437 */
        return this.loanInterestMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setLoanInterestMoneyMonthRate(BigDecimal loanInterestMoneyMonthRate)
    /*     */ {
        /* 445 */
        this.loanInterestMoneyMonthRate = loanInterestMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getServiceMoneyMonthRate()
    /*     */ {
        /* 452 */
        return this.serviceMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setServiceMoneyMonthRate(BigDecimal serviceMoneyMonthRate)
    /*     */ {
        /* 459 */
        this.serviceMoneyMonthRate = serviceMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getConsultationMoneyMonthRate()
    /*     */ {
        /* 466 */
        return this.consultationMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setConsultationMoneyMonthRate(BigDecimal consultationMoneyMonthRate)
    /*     */ {
        /* 474 */
        this.consultationMoneyMonthRate = consultationMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherOneFundMoneyMonthRate()
    /*     */ {
        /* 481 */
        return this.otherOneFundMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherOneFundMoneyMonthRate(BigDecimal otherOneFundMoneyMonthRate)
    /*     */ {
        /* 489 */
        this.otherOneFundMoneyMonthRate = otherOneFundMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherTwoFundMoneyMonthRate()
    /*     */ {
        /* 496 */
        return this.otherTwoFundMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTwoFundMoneyMonthRate(BigDecimal otherTwoFundMoneyMonthRate)
    /*     */ {
        /* 504 */
        this.otherTwoFundMoneyMonthRate = otherTwoFundMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getOtherTreeFundMoneyMonthRate()
    /*     */ {
        /* 511 */
        return this.otherTreeFundMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTreeFundMoneyMonthRate(BigDecimal otherTreeFundMoneyMonthRate)
    /*     */ {
        /* 519 */
        this.otherTreeFundMoneyMonthRate = otherTreeFundMoneyMonthRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getServiceMoneyWay()
    /*     */ {
        /* 526 */
        return this.serviceMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setServiceMoneyWay(String serviceMoneyWay)
    /*     */ {
        /* 533 */
        this.serviceMoneyWay = serviceMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getConsultationMoneyWay()
    /*     */ {
        /* 540 */
        return this.consultationMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setConsultationMoneyWay(String consultationMoneyWay)
    /*     */ {
        /* 547 */
        this.consultationMoneyWay = consultationMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getOtherOneFundMoneyWay()
    /*     */ {
        /* 554 */
        return this.otherOneFundMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherOneFundMoneyWay(String otherOneFundMoneyWay)
    /*     */ {
        /* 561 */
        this.otherOneFundMoneyWay = otherOneFundMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getOtherTwoFundMoneyWay()
    /*     */ {
        /* 568 */
        return this.otherTwoFundMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTwoFundMoneyWay(String otherTwoFundMoneyWay)
    /*     */ {
        /* 575 */
        this.otherTwoFundMoneyWay = otherTwoFundMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getOtherTreeFundMoneyWay()
    /*     */ {
        /* 582 */
        return this.otherTreeFundMoneyWay;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOtherTreeFundMoneyWay(String otherTreeFundMoneyWay)
    /*     */ {
        /* 589 */
        this.otherTreeFundMoneyWay = otherTreeFundMoneyWay;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\ProjectBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */