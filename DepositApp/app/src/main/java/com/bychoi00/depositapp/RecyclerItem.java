package com.bychoi00.depositapp;

public class RecyclerItem {
    public String _Id;
    public String Name;
    public String Rate;
    public String Decase;
    public String Dudate;
    public String Mmoney;
    public String Total;
    public String Memo;

    public String get_Id() {
        return _Id;
    }

    public void set_Id(String _Id) {
        this._Id = _Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getDecase() {
        return Decase;
    }

    public void setDecase(String decase) {
        Decase = decase;
    }

    public String getDudate() {
        return Dudate;
    }

    public void setDudate(String dudate) {
        Dudate = dudate;
    }

    public String getMmoney() {
        return Mmoney;
    }

    public void setMmoney(String mmoney) {
        Mmoney = mmoney;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public RecyclerItem(String id, String name, String rate, String decase, String dudate, String mMoney, String total, String memo) {
        _Id = id;
        Name = name;
        Rate = rate;
        Decase = decase;
        Dudate = dudate;
        Mmoney = mMoney;
        Total = total;
        Memo = memo;
    }

    public RecyclerItem(){

    }

}
