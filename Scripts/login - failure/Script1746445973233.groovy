import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.link)

WebUI.click(findTestObject('Login Page/Page_login/i_CURA Healthcare_fa fa-bars'))

WebUI.click(findTestObject('Login Page/Page_login/a_Login'))

WebUI.setText(findTestObject('Login Page/Page_login/input_Username_username'), findTestData('Credential').getValue(1, 3))

WebUI.setMaskedText(findTestObject('Login Page/Page_login/input_Password_password'), findTestData('Credential').getValue(
        1, 4))

WebUI.click(findTestObject('Login Page/Page_login/button_Login'))

WebUI.verifyElementPresent(findTestObject('Login Page/Page_login/p_Login failed Please ensure the username and password are valid'), 
    0, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.closeBrowser()

