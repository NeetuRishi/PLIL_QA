package com.gemini.PLIL.StepDefination;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;

public class PLIL {
    @Before
    public void start() throws GemException {
        DriverManager.setUpBrowser();
    }
}
