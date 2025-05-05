# katalon-KLG 🚀

## 📖 Project Overview
This project utilizes **Katalon Studio** to automate testing for various application scenarios. It includes scripts for testing user authentication, appointment scheduling, and other critical functionalities to ensure the application's reliability and performance.

## 📂 Folder Structure
Here's an overview of the key folders in this project:

- **📜 Scripts/**  
  Contains test scripts for specific scenarios:
  - `login - success/`  
    ✅ Scripts for testing successful login scenarios.
  - `logout/`  
    🚪 Scripts for testing logout functionality.
  - `appointment - seoul - none/`  
    🏥 Scripts for scheduling appointments in Seoul without insurance.
  - `appointment - tokyo - medicare/`  
    🏙️ Scripts for scheduling appointments in Tokyo with Medicare insurance.
  - `appointment - hongkong - medicaid/`  
    🌉 Scripts for scheduling appointments in Hong Kong with Medicaid insurance.

- **🧪 Test Cases/**  
  Contains test cases linked to the scripts in the `Scripts/` folder.

- **📦 Object Repository/**  
  Stores UI elements and objects used in the test scripts, such as buttons, input fields, and dropdowns.

- **📊 Data Files/**  
  Includes test data for parameterized testing, enabling dynamic input during test execution.

- **📁 Reports/**  
  Automatically generated test execution reports for tracking results and debugging.

## 🛠️ How to Use
1. Open the project in **Katalon Studio**.
2. Navigate to the `Scripts/` folder and select the desired test script.
3. Run the script using the play button ▶️ in Katalon Studio.
4. Review the results in the `Reports/` folder.

## ✅ Prerequisites
- Install **Katalon Studio** on your system.
- Ensure all test objects and test data are properly configured.

## 🤝 Contribution
We welcome contributions! Feel free to:
- Add new test scripts.
- Improve existing scripts.
- Submit a pull request with your changes.

## 📜 License
This project is licensed under the [MIT License](LICENSE).

---

💡 **Tip:** Regularly update the `Object Repository` and `Data Files` to ensure compatibility with the latest application changes.
