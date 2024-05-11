# 🚮 Smart Dustbin

The Smart Dustbin project is a cutting-edge waste management solution that leverages advanced technology to automate waste disposal, enhance environmental sustainability, and ensure hygiene. Developed at the SRM Institute of Science and Technology, this innovative system utilizes a combination of sensors, microcontrollers, IoT connectivity, and voice recognition to provide a smarter waste management solution on campus.

## 📑 Table of Contents
- [🌟 Introduction](#-introduction)
- [✨ Features](#-features)
- [🏗️ System Architecture](#%EF%B8%8F-system-architecture)
- [🔩 Hardware Components](#-hardware-components)
- [💻 Software Requirements](#-software-requirements)
- [🔧 Installation](#-installation)
- [📊 Usage](#-usage)
- [💡 Tinkercad Simulation](#-tinkercad-simulation)
- [🤝 Contributing](#-contributing)
- [📜 License](#-license)

## 🌟 Introduction
The Smart Dustbin is designed to streamline the waste disposal process, making it hands-free and intelligent. It's perfectly suited for busy public spaces, reducing the need to touch waste bins and promoting efficient waste sorting and recycling.

## ✨ Features
- **Automatic Lid Opening** 🚪: Opens the lid automatically as someone approaches, using an ultrasonic sensor.
- **Waste Segregation** ♻️: Separates waste into biodegradable, hazardous, and non-biodegradable categories via voice commands.
- **Fill Level Monitoring** 📏: Uses sensors to monitor how full the bin is and alerts when it's time to be emptied.
- **Voice Command Recognition** 🎤: Allows for hands-free operation with simple voice commands.
- **Solar-Powered** ☀️: Utilizes solar panels for an eco-friendly power source.
- **IoT Connectivity** 🌐: Integrates with Blynk for remote monitoring and user notifications.

## 🏗️ System Architecture
The Smart Dustbin uses a primary ultrasonic sensor for motion detection, controlling the lid with a servo motor. A microphone captures voice commands for waste segregation, while a secondary sensor monitors the fill level. The system is powered by a solar panel and managed through an Arduino board.

## 🔩 Hardware Components
- Arduino Microcontroller
- Ultrasonic Sensors
- Servo Motors
- Microphone
- Solar Panel
- Rechargeable Battery
- LED Indicators/Buzzers
- Bluetooth/Wi-Fi Module
- Voice Recognition Module

## 💻 Software Requirements
- Arduino IDE
- Blynk Library
- Voice Recognition Library

## 🔧 Installation
Follow these steps to set up your Smart Dustbin:
1. Assemble the hardware as per the system architecture.
2. Install the Arduino IDE and the necessary libraries.
3. Upload the provided code to the Arduino.
4. Configure the Blynk app for IoT connectivity.
5. Position the dustbin appropriately, ensuring good exposure for the solar panels.

## 📊 Usage
Approach the dustbin and it will open for you. Issue a voice command to specify the type of waste, and the bin will direct it to the correct compartment. Use the Blynk app for status updates and alerts.

## 💡 Tinkercad Simulation
Explore our basic simulation of the Smart Dustbin project on Tinkercad to understand its workings and design. [View Simulation](https://www.tinkercad.com/things/d8yIaYku1ua-smart-dustbin-using-arduino?sharecode=BfhNUhCUjMIQ5g62aLQN229eXLVHDcg2Ed9FjRQc2co)

## 🤝 Contributing
Your contributions are welcome and greatly valued. Here's how you can contribute:
1. Fork the project repository.
2. Create a new feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a new Pull Request.

## 📜 License
This project is licensed under the MIT License - see the `LICENSE` file for details.
