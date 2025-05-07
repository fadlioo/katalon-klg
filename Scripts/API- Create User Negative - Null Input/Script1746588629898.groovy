import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper

// Payload dengan beberapa nilai yang diubah menjadi null
def jsonPayload = '''{
  "id": null,
  "username": null,
  "firstName": null,
  "lastName": null,
  "email": null,
  "password": null,
  "phone": null,
  "userStatus": null
}'''

// Kirim request dengan payload yang sudah diubah
def response = WS.sendRequest(findTestObject('API/POST - Create User', [('body') : jsonPayload]))

// Verifikasi Status Code
WS.verifyResponseStatusCode(response, 200)

// Verifikasi Response Body
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Pastikan response body berisi data yang diharapkan
assert jsonResponse.code == 200 
