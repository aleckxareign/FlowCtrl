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

## ✨ Key Features

### 👤 User System
- Sign Up & Login  
- Regular & Premium accounts  
- Password validation  
- In-memory user storage  

### 📅 Cycle Tracking
- Start & end date logging  
- Auto-computed duration  
- Symptom recording (comma-separated list)  

### 😊 Mood Tracking
- Mood rating (1–5)  
- Automatic mood label conversion  
- Average mood analysis  

### 📈 Premium Features
- Health insights dashboard  
- Cycle regularity score  
- Mood-based wellness tips  

### 🔮 Predictive Analytics
Automatically estimates:  
- Next period  
- Menstrual phase  
- Follicular phase  
- Ovulation  
- Luteal phase  

Uses variance-based stability for adaptive predictions.

### 📋 History Viewer
- Fully formatted console table  
- Shows duration, symptoms, mood, and more  

---

## 🧠 OOP Concepts Used

### 🔷 Encapsulation
Private fields with getters/setters across classes.

### 🔷 Inheritance
- `User` → `PremiumUser`  
- `Cycle` → `MoodCycle`  
- `Person` as abstract base  

### 🔷 Polymorphism
Method overriding (e.g., `isPremium()`), dynamic dispatch in menus.

### 🔷 Abstraction
Abstract classes unify general behavior; child classes customize functionality.

---

## ⚙️ Tech Requirements
- **Java 17 or later**

---

## 📂 Project Structure
```

/FlowCtrl
├── FlowCtrl.java         # Main controller
├── User.java             # Regular user
├── PremiumUser.java      # Premium account handling
├── Person.java           # Abstract parent class
├── Cycle.java            # Cycle data model
├── MoodCycle.java        # Subclass with mood tracking
└── README.md

````

---

## 🚀 How to Run
```bash
javac *.java
java FlowCtrl
````

---

## 📝 Sample Output

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
Your recent moods show some stress or fatigue. Try slowing down, hydrating, or taking time for yourself.

---

## 🔮 Prediction

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


## 👥 Contributors  
| Member | Role |
|--------|------|
| **Boo, Vianci Mariz G.** <br> <img src="https://github.com/user-attachments/assets/2c04791e-1481-4b8c-b740-34ca3a33ace2" width="125"> | Developer, Documentation, Tester, Designer |
| **Bugtong, Aleckxa Reign D.** <br> <img src="https://github.com/user-attachments/assets/48f7a242-fe15-4529-9e19-392a662e6527" width="115"> | Developer, Documentation, Tester, Designer |
| **Cruzat, Angelyn A.** <br> <img src="https://github.com/user-attachments/assets/954bb0ed-286f-4190-a638-a8a308bbe1f7" width="140"> | Developer, Documentation, Tester, Designer |
| **Rioflorido, Juliana Cecile P.** <br> <img src="https://github.com/user-attachments/assets/6732229e-731f-4033-b31f-883d555dd8cc" width="140"> | Developer, Documentation, Tester, Designer |


---

## 💗 Acknowledgments

We sincerely thank our instructor for guiding and supporting us throughout this Java OOP project.

---

## ⚠️ Disclaimer

This tool provides estimates only.
FlowCtrl is **not** a medical device and should not replace professional health advice.


