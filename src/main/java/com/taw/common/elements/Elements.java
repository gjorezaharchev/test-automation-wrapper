package com.taw.common.elements;

/**
 * @author gjore.zaharchev
 */
public class Elements extends ElementBase {

    protected final Browser browser = new Browser();
    protected final Navigate navigate = new Navigate();
    protected final Button button = new Button();
    protected final Button link = new Button();
    protected final DropDown dropdown = new DropDown();
    protected final Input input = new Input();
    protected final Alerts alert = new Alerts();

    protected final Extract extract = new Extract();
    protected final Validate validate = new Validate();

    protected final Misc misc = new Misc();
    protected final Wait wait = new Wait();

    protected final Database database = new Database();
    protected final Files files = new Files();
    protected final DataSources datasources = new DataSources();


}