#include <Servo.h>
#include <NewPing.h>
#include <BlynkSimpleStream.h>

// Replace with your Blynk Auth Token
char auth[] = "Your_Blynk_Auth_Token";

// Pin definitions for the ultrasonic sensors and servo
const int TRIG_PIN_1 = 5; // Ultrasonic sensor for lid opening
const int ECHO_PIN_1 = 6;
const int TRIG_PIN_2 = 9; // Ultrasonic sensor for fill level
const int ECHO_PIN_2 = 10;
const int SERVO_PIN = 7; // Servo motor for the lid

// Define the maximum distance for measuring in centimeters
const int MAX_DISTANCE = 200;

// Create NewPing objects for each ultrasonic sensor
NewPing sonar1(TRIG_PIN_1, ECHO_PIN_1, MAX_DISTANCE);
NewPing sonar2(TRIG_PIN_2, ECHO_PIN_2, MAX_DISTANCE);

// Create servo object
Servo lidServo;

void setup() {
  // Start the serial communication
  Serial.begin(9600);

  // Start Blynk
  Blynk.begin(auth, Serial);

  // Attach the servo
  lidServo.attach(SERVO_PIN);
  lidServo.write(0); // Ensure the lid is closed on startup
}

void loop() {
  Blynk.run(); // Run Blynk process

  // Measure distance to check for object approach
  int distance1 = sonar1.ping_cm();

  // If something is detected within 50 cm, open the lid
  if (distance1 > 0 && distance1 < 50) {
    lidServo.write(90); // Replace 90 with the angle that opens your lid
  } else {
    lidServo.write(0); // Replace 0 with the angle that closes your lid
  }

  // Measure the fill level
  int distance2 = sonar2.ping_cm();

  // If the fill level reaches a certain threshold, send a notification
  if (distance2 > 0 && distance2 < 20) { // Adjust 20 to the threshold distance
    Blynk.notify("Dustbin is almost full!");
  }

  // Delay to prevent excessive readings and notifications
  delay(1000);
}
