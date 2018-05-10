package com.kakarot.plcenter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Caaccteny implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String osbid;
    private String vouchertype;
    private String voucherno;
    private Integer iscusacct;
    private String acctno;
    private String currtype;
    private Long entryno;
    private Long entrypty;
    private String pid;
    private String trxcode;
    private String trxid;
    private String refvoucherno;
    private String parenttrxid;
    private String childtrxid;
    private String entrydate;
    private Date entrytime;
    private Integer crdr;
    private Long amount;
    private Long curbal;
    private String reciporgtype;
    private String reciporgcode;
    private String recipacctno;
    private Integer postflag;
    private String postdate;
    private Date posttime;
    private String postbatch;
    private Integer genledflag;
    private String genleddate;
    private Date genledtime;
    private String genledbatch;
    private String memo;
    private Integer isrevd;
    private Integer entrytype;
    private Date revtime;
    private Integer revtype;
    private Long entrybatch;
    private String acctname;
    private Long reglimitcus;
    private Long reglimitca;
    private Integer reglimitacct;
    private String accttype;
    private Date createdTime;
    private Date updatedTime;

    public Long getId()
    {
        /* 194 */     return this.id;
    }

    public void setId(Long id) {
        /* 198 */     this.id = id;
    }

    public String getOsbid()
    {
        /* 205 */     return this.osbid;
    }

    public void setOsbid(String osbid)
    {
        /* 212 */     this.osbid = osbid;
    }

    public String getVouchertype()
    {
        /* 219 */     return this.vouchertype;
    }

    public void setVouchertype(String vouchertype)
    {
        /* 226 */     this.vouchertype = vouchertype;
    }

    public String getVoucherno()
    {
        /* 233 */     return this.voucherno;
    }

    public void setVoucherno(String voucherno)
    {
        /* 240 */     this.voucherno = voucherno;
    }

    public Integer getIscusacct()
    {
        /* 247 */     return this.iscusacct;
    }

    public void setIscusacct(Integer iscusacct)
    {
        /* 254 */     this.iscusacct = iscusacct;
    }

    public String getAcctno()
    {
        /* 261 */     return this.acctno;
    }

    public void setAcctno(String acctno)
    {
        /* 268 */     this.acctno = acctno;
    }

    public String getCurrtype()
    {
        /* 275 */     return this.currtype;
    }

    public void setCurrtype(String currtype)
    {
        /* 282 */     this.currtype = currtype;
    }

    public Long getEntryno()
    {
        /* 289 */     return this.entryno;
    }

    public void setEntryno(Long entryno)
    {
        /* 296 */     this.entryno = entryno;
    }

    public Long getEntrypty()
    {
        /* 303 */     return this.entrypty;
    }

    public void setEntrypty(Long entrypty)
    {
        /* 310 */     this.entrypty = entrypty;
    }

    public String getPid()
    {
        /* 317 */     return this.pid;
    }

    public void setPid(String pid)
    {
        /* 324 */     this.pid = pid;
    }

    public String getTrxcode()
    {
        /* 331 */     return this.trxcode;
    }

    public void setTrxcode(String trxcode)
    {
        /* 338 */     this.trxcode = trxcode;
    }

    public String getTrxid()
    {
        /* 345 */     return this.trxid;
    }

    public void setTrxid(String trxid)
    {
        /* 352 */     this.trxid = trxid;
    }

    public String getRefvoucherno()
    {
        /* 359 */     return this.refvoucherno;
    }

    public void setRefvoucherno(String refvoucherno)
    {
        /* 366 */     this.refvoucherno = refvoucherno;
    }

    public String getParenttrxid()
    {
        /* 373 */     return this.parenttrxid;
    }

    public void setParenttrxid(String parenttrxid)
    {
        /* 380 */     this.parenttrxid = parenttrxid;
    }

    public String getChildtrxid()
    {
        /* 387 */     return this.childtrxid;
    }

    public void setChildtrxid(String childtrxid)
    {
        /* 394 */     this.childtrxid = childtrxid;
    }

    public String getEntrydate()
    {
        /* 401 */     return this.entrydate;
    }

    public void setEntrydate(String entrydate)
    {
        /* 408 */     this.entrydate = entrydate;
    }

    public Date getEntrytime()
    {
        /* 415 */     return this.entrytime;
    }

    public void setEntrytime(Date entrytime)
    {
        /* 422 */     this.entrytime = entrytime;
    }

    public Integer getCrdr()
    {
        /* 429 */     return this.crdr;
    }

    public void setCrdr(Integer crdr)
    {
        /* 436 */     this.crdr = crdr;
    }

    public Long getAmount()
    {
        /* 443 */     return this.amount;
    }

    public void setAmount(Long amount)
    {
        /* 450 */     this.amount = amount;
    }

    public Long getCurbal()
    {
        /* 457 */     return this.curbal;
    }

    public void setCurbal(Long curbal)
    {
        /* 464 */     this.curbal = curbal;
    }

    public String getReciporgtype()
    {
        /* 471 */     return this.reciporgtype;
    }

    public void setReciporgtype(String reciporgtype)
    {
        /* 478 */     this.reciporgtype = reciporgtype;
    }

    public String getReciporgcode()
    {
        /* 485 */     return this.reciporgcode;
    }

    public void setReciporgcode(String reciporgcode)
    {
        /* 492 */     this.reciporgcode = reciporgcode;
    }

    public String getRecipacctno()
    {
        /* 499 */     return this.recipacctno;
    }

    public void setRecipacctno(String recipacctno)
    {
        /* 506 */     this.recipacctno = recipacctno;
    }

    public Integer getPostflag()
    {
        /* 513 */     return this.postflag;
    }

    public void setPostflag(Integer postflag)
    {
        /* 520 */     this.postflag = postflag;
    }

    public String getPostdate()
    {
        /* 527 */     return this.postdate;
    }

    public void setPostdate(String postdate)
    {
        /* 534 */     this.postdate = postdate;
    }

    public Date getPosttime()
    {
        /* 541 */     return this.posttime;
    }

    public void setPosttime(Date posttime)
    {
        /* 548 */     this.posttime = posttime;
    }

    public String getPostbatch()
    {
        /* 555 */     return this.postbatch;
    }

    public void setPostbatch(String postbatch)
    {
        /* 562 */     this.postbatch = postbatch;
    }

    public Integer getGenledflag()
    {
        /* 569 */     return this.genledflag;
    }

    public void setGenledflag(Integer genledflag)
    {
        /* 576 */     this.genledflag = genledflag;
    }

    public String getGenleddate()
    {
        /* 583 */     return this.genleddate;
    }

    public void setGenleddate(String genleddate)
    {
        /* 590 */     this.genleddate = genleddate;
    }

    public Date getGenledtime()
    {
        /* 597 */     return this.genledtime;
    }

    public void setGenledtime(Date genledtime)
    {
        /* 604 */     this.genledtime = genledtime;
    }

    public String getGenledbatch()
    {
        /* 611 */     return this.genledbatch;
    }

    public void setGenledbatch(String genledbatch)
    {
        /* 618 */     this.genledbatch = genledbatch;
    }

    public String getMemo()
    {
        /* 625 */     return this.memo;
    }

    public void setMemo(String memo)
    {
        /* 632 */     this.memo = memo;
    }

    public Integer getIsrevd()
    {
        /* 639 */     return this.isrevd;
    }

    public void setIsrevd(Integer isrevd)
    {
        /* 646 */     this.isrevd = isrevd;
    }

    public Integer getEntrytype()
    {
        /* 653 */     return this.entrytype;
    }

    public void setEntrytype(Integer entrytype)
    {
        /* 660 */     this.entrytype = entrytype;
    }

    public Date getRevtime()
    {
        /* 667 */     return this.revtime;
    }

    public void setRevtime(Date revtime)
    {
        /* 674 */     this.revtime = revtime;
    }

    public Integer getRevtype()
    {
        /* 681 */     return this.revtype;
    }

    public void setRevtype(Integer revtype)
    {
        /* 688 */     this.revtype = revtype;
    }

    public Long getEntrybatch()
    {
        /* 695 */     return this.entrybatch;
    }

    public void setEntrybatch(Long entrybatch)
    {
        /* 702 */     this.entrybatch = entrybatch;
    }

    public String getAcctname()
    {
        /* 709 */     return this.acctname;
    }

    public void setAcctname(String acctname)
    {
        this.acctname = acctname;
    }

    public Long getReglimitcus()
    {
        return this.reglimitcus;
    }

    public void setReglimitcus(Long reglimitcus)
    {
        /* 730 */     this.reglimitcus = reglimitcus;
    }

    public Long getReglimitca()
    {
        return this.reglimitca;
    }

    public void setReglimitca(Long reglimitca)
    {
        this.reglimitca = reglimitca;
    }

    public Integer getReglimitacct()
    {
        return this.reglimitacct;
    }

    public void setReglimitacct(Integer reglimitacct)
    {
        this.reglimitacct = reglimitacct;
    }

    public String getAccttype()
    {
        return this.accttype;
    }

    public void setAccttype(String accttype)
    {
        this.accttype = accttype;
    }

    public Date getCreatedTime()
    {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime)
    {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime()
    {
        return this.updatedTime;
    }

    public void setUpdatedTime(Date updatedTime)
    {
        this.updatedTime = updatedTime;
    }
}