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

FlowCtrl is a Java console application that helps users track their menstrual cycles, symptoms, and emotional patterns.  
The system analyzes cycle data and provides predictive insights and health analytics, especially for Premium Users.

This project demonstrates strong application of **Object-Oriented Programming (OOP)** principles through a clean, modular class structure.

---

# 🧩 Program Structure

## **Class Hierarchy Diagram**

```

BaseUser (abstract)
├── User
└── PremiumUser

Cycle
└── MoodCycle

Person (abstract)
└── User implementations

FlowCtrl (Main Controller)

```

---

# 🏗️ Main Classes & Their Roles

| Class | Purpose | Key Features |
|-------|---------|--------------|
| **FlowCtrl** | Main controller class | Menu navigation, authentication, business logic |
| **BaseUser** | Abstract parent class | User management, cycle history storage |
| **User** | Regular user | Basic cycle tracking |
| **PremiumUser** | Premium user tier | Advanced analytics & health insights |
| **Cycle** | Cycle data model | Start/end dates, duration calculation, symptoms |
| **MoodCycle** | Enhanced cycle model | Mood recording + emotional assessment |
| **Person** | Abstract identity class | Name, email, password fields |

---

# 🔧 FlowCtrl Key Methods

| Method | Description |
|--------|-------------|
| **main()** | Entry point of the program |
| **signUp()** | Registers new users (regular or premium) |
| **login()** | Handles secure login/authentication |
| **mainMenu()** | Main navigation hub |
| **addCycle()** | Adds a full cycle with dates, symptoms, mood |
| **viewCycleHistory()** | Shows formatted table of past cycles |
| **predictNextCycle()** | Forecasts phases and next period |
| **getAverageCycleLength()** | Computes average duration |
| **getMostCommonSymptom()** | Finds symptom frequency patterns |

---

# ✨ Key Features

### 👤 User System
- Sign Up & Login  
- Regular & Premium user accounts  
- Password validation  
- Stores users in memory  

### 📅 Cycle Tracking
- Start & end date logging  
- Automatic duration calculation  
- Symptom recording  

### 😊 Mood Tracking
- Mood score (1–5)  
- Converted emotional label  
- Mood averaging  

### 🌟 Premium Features
- Cycle regularity score  
- Health insights dashboard  
- Mood-based wellness suggestions  

### 🔮 Predictive Analytics
Automatically estimates:
- Next period  
- Menstrual phase  
- Follicular phase  
- Ovulation  
- Luteal phase  

### 📋 Cycle History Viewer
- Neatly formatted console table  
- Shows all relevant cycle information  

---

# 🧠 OOP Concepts Used

### 🔷 Encapsulation  
Private fields with controlled access.

### 🔷 Inheritance  
- `User` inherits from `BaseUser`  
- `PremiumUser` extends `User`  
- `MoodCycle` extends `Cycle`

### 🔷 Polymorphism  
Overridden methods like `isPremium()` and feature-specific behavior.

### 🔷 Abstraction  
Shared logic in abstract classes (`BaseUser`, `Person`).

---

# ⚙️ Tech Requirements

- **Java 17 or later**

---

# 📂 Project Structure

```

/FlowCtrl
├── FlowCtrl.java
├── BaseUser.java
├── User.java
├── PremiumUser.java
├── Person.java
├── Cycle.java
├── MoodCycle.java
└── README.md

````

---

# 🚀 How to Run the Program

## **Step 1: Make Sure You Have Java Installed**
If not, download from:  
https://www.java.com/download  

Install normally.

---

## **Step 2: Place All Files in One Folder**
Make sure these files are together:

- FlowCtrl.java  
- BaseUser.java  
- User.java  
- PremiumUser.java  
- Person.java  
- Cycle.java  
- MoodCycle.java  

---

## **Step 3: Open Command Prompt / Terminal**

### Windows:
Press **Windows Key + R** → type `cmd` → Enter  

### Mac:
Press **Command + Space** → type `terminal` → Enter  

---

## **Step 4: Go to Your Program Folder**

Example:
```bash
cd Downloads/FlowCtrl
````

---

## **Step 5: Compile the Program**

```bash
javac *.java
```

If no errors appear, you're good!

---

## **Step 6: Run the Program**

```bash
java FlowCtrl
```

---

# 📝 Sample Output

### **Cycle Table**

```
#   | Start Date | End Date   | Duration | Symptoms                   | Mood
------------------------------------------------------------------------------------------
1   | 2025-09-06 | 2025-09-10 | 5        | cramps, fatigue, stress    | Negative
2   | 2025-10-09 | 2025-10-13 | 5        | cramps, fatigue, stress    | Negative
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

---

# 🔮 Prediction Example

```
Predicted Menstrual Phases Based on Your Average Data:
-------------------------------------------------------------------------------------
Phase        | Start Date     | End Date
-------------------------------------------------------------------------------------
Menstrual    | 2025-12-13     | 2025-12-17
Follicular   | 2025-12-18     | 2025-12-27
Ovulation    | 2025-12-28     | 2025-12-29
Luteal       | 2025-12-30     | 2026-01-12
-------------------------------------------------------------------------------------
```

---

# 👥 Contributors

| Member                                                                                                                                        | Role                                       |
| --------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------ |
| **Boo, Vianci Mariz G.** <br><img src="https://github.com/user-attachments/assets/2c04791e-1481-4b8c-b740-34ca3a33ace2" width="125">          | Developer, Documentation, Tester, Designer |
| **Bugtong, Aleckxa Reign D.** <br><img src="https://github.com/user-attachments/assets/48f7a242-fe15-4529-9e19-392a662e6527" width="115">     | Developer, Documentation, Tester, Designer |
| **Cruzat, Angelyn A.** <br><img src="https://github.com/user-attachments/assets/954bb0ed-286f-4190-a638-a8a308bbe1f7" width="140">            | Developer, Documentation, Tester, Designer |
| **Rioflorido, Juliana Cecile P.** <br><img src="https://github.com/user-attachments/assets/6732229e-731f-4033-b31f-883d555dd8cc" width="140"> | Developer, Documentation, Tester, Designer |

---

# 💗 Acknowledgments

We sincerely thank our instructor for guiding and supporting us throughout this Java OOP project.

---

# ⚠️ Disclaimer

FlowCtrl provides **estimates only**.
It is **not** a medical device and should not replace professional healthcare advice.

```


Just tell me!
```
