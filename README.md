<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:ff9ec4,50:c084fc,100:f472b6&height=220&section=header&text=FlowCtrl&fontSize=72&fontColor=ffffff&fontAlignY=40&desc=Menstrual%20Cycle%20%E2%80%A2%20Symptoms%20%E2%80%A2%20Mood%20Tracker&descAlignY=58&descColor=ffe4f0" />

</div>

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-OOP-c084fc?style=for-the-badge)
![Console App](https://img.shields.io/badge/Type-Console%20App-f472b6?style=for-the-badge)
![CS 2102](https://img.shields.io/badge/Course-CS%202102-ff9ec4?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=for-the-badge)

</div>

<br/>

<div align="center">

> *"Your cycle, understood."*
> A Java console application that helps users track menstrual cycles, symptoms, and emotional patterns — with predictive analytics for Premium users.

</div>

---

## 👥 Team Members

<div align="center">

| | Name | Role |
|--|------|------|
| <img src="https://github.com/user-attachments/assets/2c04791e-1481-4b8c-b740-34ca3a33ace2" width="60" style="border-radius:50%"> | **Boo, Vianci Mariz G.** | Developer · Documentation · Tester · Designer |
| <img src="https://github.com/user-attachments/assets/48f7a242-fe15-4529-9e19-392a662e6527" width="60" style="border-radius:50%"> | **Bugtong, Aleckxa Reign D.** | Developer · Documentation · Tester · Designer |
| <img src="https://github.com/user-attachments/assets/954bb0ed-286f-4190-a638-a8a308bbe1f7" width="60" style="border-radius:50%"> | **Cruzat, Angelyn A.** | Developer · Documentation · Tester · Designer |
| <img src="https://github.com/user-attachments/assets/6732229e-731f-4033-b31f-883d555dd8cc" width="60" style="border-radius:50%"> | **Rioflorido, Juliana Cecile P.** | Developer · Documentation · Tester · Designer |

</div>

---

## 📌 Overview

**FlowCtrl** is a Java console application built for **CS 2102** that empowers users to take control of their menstrual health. The system allows users to log cycles, track symptoms, and monitor mood — then uses that data to generate health insights and cycle predictions.

The project is a comprehensive demonstration of the four pillars of **Object-Oriented Programming**, implemented through a clean, modular, and extensible class hierarchy.

### 🎯 Core Goals
- Give users a private, easy-to-use tool for cycle awareness
- Apply OOP principles (Encapsulation, Inheritance, Polymorphism, Abstraction) in a real-world context
- Provide meaningful health insights beyond simple data logging

---

## ✨ Features

### 👤 User System
- ✅ Sign up and login with password validation
- ✅ Two account tiers: **Standard** and **Premium**
- ✅ In-memory user management

### 📅 Cycle Tracking
- ✅ Log start and end dates per cycle
- ✅ Automatic cycle duration calculation
- ✅ Record symptoms per cycle entry
- ✅ Full cycle history displayed as a formatted table

### 😊 Mood Tracking
- ✅ Mood score input (1–5 scale)
- ✅ Scores converted to descriptive mood labels
- ✅ Mood averaging across cycles

### 🌟 Premium Features
- ✅ Health insights dashboard
- ✅ Average cycle length and duration analytics
- ✅ Cycle regularity score (out of 100)
- ✅ Personalized mood-based wellness tips

### 🔮 Predictive Analytics
- ✅ Predicts next period start date based on history
- ✅ Forecasts all four menstrual phases:
  - 🔴 **Menstrual** · 🌱 **Follicular** · 🌕 **Ovulation** · 🍂 **Luteal**

---

## 🏗️ Architecture & Class Structure

```
FlowCtrl/
└── 📁 src/
    ├── 📂 cycle/
    │   ├── ☕ Cycle.java          → Core cycle data model
    │   └── ☕ MoodCycle.java      → Extended cycle with enhanced mood display
    │
    ├── 📂 main/
    │   └── ☕ FlowCtrl.java       → Main controller & CLI entry point
    │
    ├── 📂 user/
    │   ├── ☕ Person.java         → Abstract base class for all users
    │   ├── ☕ BaseUser.java       → Abstract class with cycle list management
    │   ├── ☕ User.java           → Standard user implementation
    │   └── ☕ PremiumUser.java    → Premium user with health insights
    │
    └── 📂 utils/
         └── ☕ Utils.java         → Shared utility methods
```

### Class Responsibilities

| Class | Type | Purpose |
|-------|------|---------|
| `FlowCtrl` | Main Controller | CLI menu, auth, cycle management, predictions |
| `Person` | Abstract Class | Base credentials; enforces `displayInfo()` |
| `BaseUser` | Abstract Class | Encapsulates cycle list; abstract `greet()` |
| `User` | Concrete Class | Standard account logic |
| `PremiumUser` | Concrete Class | Health insights and analytics |
| `Cycle` | Data Model | Dates, symptoms, mood, duration calculation |
| `MoodCycle` | Extended Model | Enhanced cycle info display |
| `Utils` | Utility Class | Shared helper methods |

---

## 🧠 OOP Concepts Demonstrated

### 🔷 Encapsulation
> *Protecting data integrity through controlled access*

Private fields exposed only through getters and setters:
```java
// Cycle.java — private fields, public getters
private LocalDate startDate;
private LocalDate endDate;
private String symptoms;
private int moodValue;

// BaseUser.java — unmodifiable list prevents external tampering
public List<Cycle> getCycles() {
    return Collections.unmodifiableList(cycles);
}
```

---

### 🔷 Inheritance
> *Modeling "is-a" relationships for code reuse*

```
Person (abstract)
└── BaseUser (abstract)
    └── User
        └── PremiumUser

Cycle
└── MoodCycle
```

- `User` **is a** `Person` — inherits credentials and base behavior
- `PremiumUser` **is a** `User` — extends with premium analytics
- `MoodCycle` **is a** `Cycle` — extends with enriched mood display

---

### 🔷 Polymorphism
> *Same interface, different behaviors*

```java
// isPremium() behaves differently per subclass
user.isPremium()         // → false
premiumUser.isPremium()  // → true

// displayInfo() has unique output per class
person.displayInfo();    // → resolved at runtime to the correct subclass
```

---

### 🔷 Abstraction
> *Hiding complexity, exposing intent*

```java
// Person.java — abstract method forces all subclasses to implement display
public abstract void displayInfo();

// BaseUser.java — abstract method enforces greeting behavior
public abstract void greet();
```

Users of the system interact with clean method calls — the internal logic stays hidden.

---

## ⚙️ Tech Requirements

- **Java 17 or later**
- No external libraries required — pure Java

---

## 🚀 How to Run

### Step 1 — Install Java
If Java is not installed: [https://www.java.com/download](https://www.java.com/download)

Verify your installation:
```bash
java --version
```

### Step 2 — Clone the Repository
```bash
git clone https://github.com/aleckxareign/FlowCtrl.git
cd FlowCtrl
```

### Step 3 — Compile
```bash
javac *.java
```

### Step 4 — Run
```bash
java FlowCtrl
```

> **Windows users:** Open Command Prompt with `Win + R` → type `cmd` → navigate to the project folder with `cd path\to\FlowCtrl`

> **Mac/Linux users:** Open Terminal → navigate with `cd path/to/FlowCtrl`

---

## 📝 Sample Output

### Cycle History Table
```
#   | Start Date | End Date   | Duration | Symptoms                   | Mood
------------------------------------------------------------------------------------------
1   | 2025-09-06 | 2025-09-10 | 5        | cramps, fatigue, stress    | Negative
2   | 2025-10-09 | 2025-10-13 | 5        | cramps, fatigue, stress    | Negative
```

### Premium Health Insights
```
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
         💗 YOUR HEALTH INSIGHTS
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Average cycle length    : 32 days
Average period duration : 5.0 days
Overall mood            : Negative
Cycle regularity score  : 99.8 / 100

💡 Health Tip:
Your recent moods suggest stress or fatigue.
Consider resting, hydrating, or taking mindful breaks.
```

### Cycle Phase Prediction
```
🔮 Predicted Menstrual Phases Based on Your Average Data:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Phase        | Start Date     | End Date
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🔴 Menstrual | 2025-12-13     | 2025-12-17
🌱 Follicular| 2025-12-18     | 2025-12-27
🌕 Ovulation | 2025-12-28     | 2025-12-29
🍂 Luteal    | 2025-12-30     | 2026-01-12
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

---

## 🚀 Future Enhancements

- 📱 **Mobile Application** — on-the-go tracking via Android/iOS
- 🔐 **Secure Cloud Storage** — encrypted backup and multi-device sync
- 📊 **Machine Learning** — smarter predictions with pattern recognition
- 🌐 **Web Dashboard** — interactive charts and visual cycle history
- 🔔 **Smart Notifications** — cycle reminders and health alerts
- 🌍 **Multi-language Support** — accessibility for global users
- 👥 **Community Features** — anonymous pattern sharing

---

## ⚠️ Disclaimer

FlowCtrl provides **estimates only** based on user-entered data.
It is **not** a medical device and should **not** replace professional healthcare advice.
Always consult a qualified healthcare provider for medical concerns.

---

## 💗 Acknowledgments

We sincerely thank **Prof. Fatima Marie Agdon** for her invaluable guidance, mentorship, and support throughout the development of this project.

---

## 📚 References

- [Java Official Documentation](https://docs.oracle.com/en/java/)
- Encapsulation, Inheritance, Polymorphism, Abstraction — Core OOP Principles

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:ff9ec4,50:c084fc,100:f472b6&height=100&section=footer" />

<sub>💗 Built with care for CS 2102 · FlowCtrl Team 2025</sub>

</div>
