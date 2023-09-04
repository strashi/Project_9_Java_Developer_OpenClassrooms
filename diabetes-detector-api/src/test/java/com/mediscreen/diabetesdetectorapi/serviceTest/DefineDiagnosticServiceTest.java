package com.mediscreen.diabetesdetectorapi.serviceTest;

import com.mediscreen.diabetesdetectorapi.service.DiabetesDetectorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DefineDiagnosticServiceTest {

    @Autowired
    private DiabetesDetectorService diabetesDetectorService;

    @Test
    public void defineDiagnosticNullTriggerWordNumberTest(){

        String response = diabetesDetectorService.defineDiagnostic(0,25, "F");

        Assertions.assertSame("aucun risque (None)",response.toString());
    }

    @Test
    public void defineDiagnosticTwoTriggerWordNumberFemaleUnder30Test(){

        String response = diabetesDetectorService.defineDiagnostic(2,25, "F");

        Assertions.assertSame("non défini (between None and In Danger)",response.toString());
    }

    @Test
    public void defineDiagnosticSixTriggerWordNumberFemaleUnder30Test(){

        String response = diabetesDetectorService.defineDiagnostic(6,25, "F");

        Assertions.assertSame("danger (In Danger)",response.toString());
    }

    @Test
    public void defineDiagnosticEightTriggerWordNumberFemaleUnder30Test(){

        String response = diabetesDetectorService.defineDiagnostic(8,25, "F");

        Assertions.assertSame("apparition précoce (Early onset)",response.toString());
    }

    @Test
    public void defineDiagnosticTwoTriggerWordNumberMaleUnder30Test(){

        String response = diabetesDetectorService.defineDiagnostic(2,25, "M");

        Assertions.assertSame("non défini (between None and In Danger)",response.toString());
    }

    @Test
    public void defineDiagnosticThreeTriggerWordNumberFemaleUnder30Test(){

        String response = diabetesDetectorService.defineDiagnostic(3,25, "M");

        Assertions.assertSame("danger (In Danger)",response.toString());
    }

    @Test
    public void defineDiagnosticFiveTriggerWordNumberFemaleUnder30Test(){

        String response = diabetesDetectorService.defineDiagnostic(5,25, "M");

        Assertions.assertSame("apparition précoce (Early onset)",response.toString());
    }

    @Test
    public void defineDiagnosticOneTriggerWordNumberFemaleAbove30Test(){

        String response = diabetesDetectorService.defineDiagnostic(1,30, "F");

        Assertions.assertSame("non défini (between None and Borderline)",response.toString());
    }

    @Test
    public void defineDiagnosticFourTriggerWordNumberFemaleAbove30Test(){

        String response = diabetesDetectorService.defineDiagnostic(4,30, "F");

        Assertions.assertSame("risque limité (Borderline)",response.toString());
    }

    @Test
    public void defineDiagnosticSixTriggerWordNumberFemaleAbove30Test(){

        String response = diabetesDetectorService.defineDiagnostic(6,30, "F");

        Assertions.assertSame("danger (In Danger)",response.toString());
    }

    @Test
    public void defineDiagnosticNineTriggerWordNumberFemaleAbove30Test(){

        String response = diabetesDetectorService.defineDiagnostic(9,30, "F");

        Assertions.assertSame("apparition précoce (Early onset)",response.toString());
    }
}
