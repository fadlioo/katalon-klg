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
//import static com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS


//def response = WS.sendRequest(findTestObject('API/GET - Get User'))
//
//WS.verifyResponseStatusCode(response, 200)

//import static com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Kirim request GET ke endpoint
def response = WS.sendRequest(findTestObject('API/GET - Get User'))

// Verifikasi response status code (200 OK)
WS.verifyResponseStatusCode(response, 200)

// Ambil nilai id dari response
def id = WS.getElementPropertyValue(response, 'id')

// Verifikasi bahwa id adalah tipe data Long (angka besar)
assert id instanceof Long : "Expected id to be of type Long, but was " + id.getClass().getName()

// Verifikasi field lainnya sesuai nilai yang diharapkan
def expectedResponse = [
	"username": "string",
	"firstName": "string",
	"lastName": "string",
	"email": "string",
	"password": "string",
	"phone": "string",
	"userStatus": 0
]

WS.verifyElementPropertyValue(response, 'username', expectedResponse.username)
WS.verifyElementPropertyValue(response, 'firstName', expectedResponse.firstName)
WS.verifyElementPropertyValue(response, 'lastName', expectedResponse.lastName)
WS.verifyElementPropertyValue(response, 'email', expectedResponse.email)
WS.verifyElementPropertyValue(response, 'password', expectedResponse.password)
WS.verifyElementPropertyValue(response, 'phone', expectedResponse.phone)
WS.verifyElementPropertyValue(response, 'userStatus', expectedResponse.userStatus)
