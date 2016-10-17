package com.omidbiz.vacation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jboss.seam.international.StatusMessage;

@Entity
@Table(name = "vacation")
public class Vacation extends BasePO
{

    public enum VacationType {
        ESTEHGHAGHI(StatusMessage.getBundleMessage("ESTEHGHAGHI", "")), BEDUNEHOGHOGH(StatusMessage.getBundleMessage("BEDUNEHOGHOGH", ""));
        private String label;

        private VacationType(String label)
        {
            this.label = label;
        }

        public String getLabel()
        {
            return label;
        }

    }

    private VacationType type;

    private User user;

    private User substitute;

    private Date fromDate;

    private Date toDate;

    @Column(name = "from_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    @Column(name = "to_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "substitute_id")
    public User getSubstitute()
    {
        return substitute;
    }

    public void setSubstitute(User substitute)
    {
        this.substitute = substitute;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "vacation_type")
    public VacationType getType()
    {
        return type;
    }

    public void setType(VacationType type)
    {
        this.type = type;
    }

}
