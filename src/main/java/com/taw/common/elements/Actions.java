package com.taw.common.elements;

import com.taw.common.utility.$;

public class Actions extends ElementBase{
    protected final Browser browser = new Browser();
    protected final Navigate navigate = new Navigate();
    protected final Button button = new Button();
    protected final Button link = new Button();
    protected final DropDown dropdown = new DropDown();
    protected final Input input = new Input();
    protected final Alerts alert = new Alerts();

    protected final Extract extract = new Extract();

    protected final Misc misc = new Misc();
    protected final Wait wait = new Wait();

    protected final Database database = new Database();
    protected final Files files = new Files();
    protected final DataSources dataSources = new DataSources();
    protected final OTP otp = new OTP();
    protected final Mailinator mailinator = new Mailinator();
    protected final Gmail gmail = new Gmail();

    protected final com.taw.common.utility.$ $ = new $();
}
