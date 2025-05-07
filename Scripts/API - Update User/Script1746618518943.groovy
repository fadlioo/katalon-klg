import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import groovy.json.JsonOutput as JsonOutput
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint


long dynamicId = System.currentTimeMillis()

String dynamicUsername = 'testUser' + new Random().nextInt(1000)

String dynamicFirstName = 'NamaDepanDinamis'

String dynamicLastName = 'NamaBelakangDinamis'

String dynamicEmail = dynamicUsername + '@example.com'

String dynamicPassword = 'passwordDinamis123'

String dynamicPhone = '08123456' + new Random().nextInt(1000)

int dynamicUserStatus = 1 

// Membuat payload JSON secara dinamis
Map<String, Object> requestBodyMap = [('id') : dynamicId // Bisa juga 0 jika API mengizinkan atau meng-generate ID sendiri
    , ('username') : dynamicUsername, ('firstName') : dynamicFirstName, ('lastName') : dynamicLastName, ('email') : dynamicEmail
    , ('password') : dynamicPassword, ('phone') : dynamicPhone, ('userStatus') : dynamicUserStatus]

String requestBodyJson = JsonOutput.toJson(requestBodyMap)

println('Request Body Dinamis: ' + requestBodyJson)

def response = WS.sendRequest(findTestObject('API/PUT - Update User', [('body') : requestBodyJson]))


WS.verifyResponseStatusCode(response, 200, FailureHandling.STOP_ON_FAILURE)


String responseBody = response.getResponseText()

println('Response Body: ' + responseBody)


JsonSlurper slurper = new JsonSlurper()

Map parsedResponse = slurper.parseText(responseBody)

WS.verifyElementPropertyValue(response, 'code', 200, FailureHandling.CONTINUE_ON_FAILURE)

println('Verifikasi \'code\': Sukses')

WS.verifyElementPropertyValue(response, 'type', 'unknown', FailureHandling.CONTINUE_ON_FAILURE)

println('Verifikasi \'type\': Sukses')

if (parsedResponse.containsKey('message')) {
    String messageValue = parsedResponse.get('message').toString( // Pastikan dikonversi ke String jika perlu
        )

    assert (messageValue != null) && !(messageValue.isEmpty())

    println('Verifikasi \'message\': Ada dan tidak kosong, Nilai: ' + messageValue)

    try {
        Long.parseLong(messageValue)

        println('Verifikasi \'message\': Format adalah angka (Long)')
    }
    catch (NumberFormatException e) {
        WS.comment('Peringatan: \'message\' bukan format angka yang valid.', FailureHandling.CONTINUE_ON_FAILURE)
    } 
} else {
    WS.comment('Gagal: Properti \'message\' tidak ditemukan dalam response.', FailureHandling.STOP_ON_FAILURE)
}

