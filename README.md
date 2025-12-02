<div align="center">

# 🌸 FlowCtrl — Menstrual Cycle & Mood Tracker  
### Menstrual Cycle • Symptoms • Mood Tracker  
### CS 2102  

**Boo, Vianci Mariz G.**  
**Bugtong, Aleckxa Reign D.**  
**Cruzat, Angelyn A.**  
**Rioflorido, Juliana Cecile P.**

</div>

---

## 📌 Overview

FlowCtrl is a **Java console application** that helps users track their menstrual cycles, symptoms, and emotional patterns. The system analyzes cycle data and provides predictive insights and health analytics, especially for Premium Users.

This project demonstrates strong application of **Object-Oriented Programming (OOP)** principles through a clean, modular class structure.

---

# 🧩 Program Structure

## **Class Hierarchy Diagram**

```


Person (abstract)
└── BaseUser (abstract)
├── User
└── PremiumUser

Cycle
└── MoodCycle

FlowCtrl (Main Controller)


```

---

# 🏗️ Main Classes & Their Roles

| Class | Purpose | Key Features / Notes |
|-------|---------|--------------------|
| **FlowCtrl** | Main controller class | CLI menu, sign-up/login, cycle management, predictions, health insights |
| **Person** | Abstract class | Stores user credentials; enforces `displayInfo()` for polymorphism |
| **BaseUser** | Abstract user class | Encapsulates `cycles` list; abstract `greet()` method |
| **User** | Standard user | Adds cycles, basic cycle tracking, overrides `displayInfo()` |
| **PremiumUser** | Premium user | Provides health insights, cycle regularity score, mood-based tips |
| **Cycle** | Cycle data model | Start/end dates, symptoms, mood, cycle length calculation |
| **MoodCycle** | Extended cycle model | Overridden display method for cycle info |

---

# 🔧 FlowCtrl Key Methods

## **FlowCtrl.java**
- `main()` → Program entry point, displays welcome menu  
- `signUp()` → Create standard or premium accounts  
- `login()` → Authenticate user  
- `mainMenu()` → Navigation hub after login  
- `addCycle()` → Input new cycle details (dates, symptoms, mood)  
- `viewCycleHistory()` → Display user's cycle history as table  
- `predictNextCycle()` → Forecast next cycle and menstrual phases  
- `getMoodString(int)` → Convert mood integer (1–5) to descriptive label  
- `getAverageCycleLength(User)` → Calculate average cycle interval  
- `getAverageDuration(User)` → Calculate average period duration  
- `getMostCommonSymptom(User)` → Determine most frequent symptom

## **Person.java**
- Abstract `displayInfo()` → Polymorphic behavior  
- Getters/setters for `name` and `password`  

## **BaseUser.java**
- `getCycles()` → Returns unmodifiable list (Encapsulation)  
- `addCycle(Cycle)` → Add cycle safely  
- Abstract `greet()` → Implemented in subclasses  

## **User.java**
- `getCycles()` / `addCycle()` → Manage cycles  
- `isPremium()` → Returns `false`  
- `displayInfo()` → Standard account info  

## **PremiumUser.java**
- `isPremium()` → Returns `true`  
- `displayInfo()` → Premium account info  
- `viewHealthInsights()` → Average cycle length, mood, regularity, and tips  

## **Cycle.java**
- Getters for all properties  
- `getCycleLength()` → Calculate number of days between start and end  

## **MoodCycle.java**
- `displayCycleInfo(int)` → Enhanced display of cycle details  

---

# ✨ Key Features

### 👤 User System
- Sign Up & Login  
- Standard & Premium accounts  
- Password validation  
- Users stored in memory  

### 📅 Cycle Tracking
- Log start & end dates  
- Automatic duration calculation  
- Symptom recording  

### 😊 Mood Tracking
- Mood score (1–5)  
- Converts score to descriptive label  
- Mood averaging  

### 🌟 Premium Features
- Health insights dashboard  
- Cycle regularity score  
- Mood-based wellness suggestions  

### 🔮 Predictive Analytics
- Predict next period  
- Menstrual phases: Menstrual, Follicular, Ovulation, Luteal  

### 📋 Cycle History Viewer
- Formatted console table with all cycle information  

---

# 🧠 OOP Concepts Used

## 🔷 Encapsulation

# Private fields with controlled access via getters and setters.

# Examples:

# - Cycle.java → startDate, endDate, symptoms, mood, moodValue

# - User.java → name, password

# - Person.java → name, password

## 🔷 Inheritance

# Represents “is-a” relationships between classes.

# Examples:

# - User extends Person → A User **is a** Person

# - PremiumUser extends User → A PremiumUser **is a** User

# - MoodCycle extends Cycle → A MoodCycle **is a** Cycle

## 🔷 Polymorphism

# Sam


---

# ⚙️ Tech Requirements

- **Java 17 or later**

---

# 📂 Project Structure

```

/FlowCtrl
├── FlowCtrl.java
├── Person.java
├── BaseUser.java
├── User.java
├── PremiumUser.java
├── Cycle.java
├── MoodCycle.java
└── README.md

````

---

# 🚀 How to Run the Program

1. **Install Java** (if not installed) → https://www.java.com/download  
2. **Place all files in one folder**  
3. **Open Terminal / Command Prompt**  
   - Windows: `Win + R` → `cmd` → Enter  
   - Mac: `Command + Space` → `terminal` → Enter  
4. **Navigate to program folder:**  
   ```bash
   cd /path/to/FlowCtrl
    ````

5. **Compile all files:**

   ```bash
   javac *.java
   ```
6. **Run the program:**

   ```bash
   java FlowCtrl
   ```

-----

# 📝 Sample Output

### **Cycle Table**

```
#   | Start Date | End Date   | Duration | Symptoms                   | Mood
------------------------------------------------------------------------------------------
1   | 2025-09-06 | 2025-09-10 | 5        | cramps, fatigue, stress    | Negative
2   | 2025-10-09 | 2025-10-13 | 5        | cramps, fatigue, stress    | Negative
```

### **Health Insights**

```
Average cycle length: 32 days
Average period duration: 5.0 days
Overall mood: Negative
Cycle regularity score: 99.8/100
```

**Health Tip:**
Your recent moods suggest stress or fatigue. Consider resting, hydrating, or taking mindful breaks.

-----

# 🔮 Prediction Example

```
Predicted Menstrual Phases Based on Your Average Data:
-------------------------------------------------------------------------------------
Phase        | Start Date     | End Date
-------------------------------------------------------------------------------------
Menstrual    | 2025-12-13     | 2025-12-17
Follicular   | 2025-12-18     | 2025-12-27
Ovulation    | 2025-12-28     | 2025-12-29
Luteal       | 2025-12-30     | 2026-01-12
-------------------------------------------------------------------------------------
```

-----

# 👥 Contributors

| Member                                                                                                                                        | Role                                       |
| --------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------ |
| **Boo, Vianci Mariz G.** <br><img src="https://github.com/user-attachments/assets/2c04791e-1481-4b8c-b740-34ca3a33ace2" width="125">          | Developer, Documentation, Tester, Designer |
| **Bugtong, Aleckxa Reign D.** <br><img src="https://github.com/user-attachments/assets/48f7a242-fe15-4529-9e19-392a662e6527" width="115">     | Developer, Documentation, Tester, Designer |
| **Cruzat, Angelyn A.** <br><img src="https://github.com/user-attachments/assets/954bb0ed-286f-4190-a638-a8a308bbe1f7" width="140">            | Developer, Documentation, Tester, Designer |
| **Rioflorido, Juliana Cecile P.** <br><img src="https://github.com/user-attachments/assets/6732229e-731f-4033-b31f-883d555dd8cc" width="140"> | Developer, Documentation, Tester, Designer |

-----

# 💗 Acknowledgments

We sincerely thank our instructor, Prof. Fatima Marie Agdon, for her valuable guidance, support, and mentorship throughout the development of this Java OOP project.

-----

# 👥 References

  - Java Official Documentation
  - Object-Oriented Programming Principles (Encapsulation, Inheritance, Polymorphism, Abstraction)

-----

# 🚀 Future Enhancements

  * **📱 Mobile Application** for on-the-go tracking
  * **🔐 Secure Cloud Storage** with encrypted data backup
  * **📊 Machine Learning** for improved prediction accuracy
  * **🌐 Web Dashboard** with interactive charts and graphs
  * **🔔 Smart Notifications** for cycle reminders and health tips
  * **👥 Community Features** for anonymous pattern sharing
  * **🌍 Multi-language Support** for global accessibility
  * **📈 Advanced Analytics** with correlation between symptoms and mood

-----

# ⚠️ Disclaimer

FlowCtrl provides **estimates only**.
It is **not** a medical device and should not replace professional healthcare advice.


