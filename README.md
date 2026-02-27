Vegetable Store POS System
A comprehensive Point-of-Sale desktop application designed specifically for vegetable retail stores, built with Java Swing and object-oriented principles.

📋 Overview
The Vegetable Store POS System is a robust desktop application that streamlines the billing and inventory management process for small to medium vegetable retail shops. It provides an intuitive interface for cashiers to quickly process customer purchases, calculate totals in real-time, and generate accurate receipts.

✨ Key Features
🧾 Receipt Management
Dynamic Receipt Generation: Automatically creates professional receipts with customer details and itemized purchases

Real-time Calculations: Instant total computation as items are added to cart

Multiple Actions: Save receipts or dismiss transactions with ease

👥 Customer Information
Capture customer full name and phone number

Store delivery/pickup location details

Maintain customer records for future reference

🥦 Product Selection
Current Price Display: Shows updated prices for vegetables

Quantity Input: Flexible quantity entry (KG/Unit based)

Multi-item Support: Add multiple products to a single transaction

Item Counter: Displays total items in cart

💰 Price Calculation
Automatic price computation based on quantity

Running total display

Support for decimal quantities and prices

Transparent pricing with itemized breakdown

📊 Order Display
Tabular view of selected items with:

Product ID

Type/Name

Quantity

Individual Price

Clean, organized layout for easy verification

🏗️ Architecture
The application follows a clean, modular architecture based on Object-Oriented Programming principles:

text
├── GUI Layer          # Swing components for user interaction
├── Models Layer       # Data structures for Products, Customers, Receipts
├── Business Logic     # Price calculation, validation, receipt generation
└── Utils              # Helper classes for formatting and utilities
Design Patterns Implemented
MVC Pattern: Separation of concerns between data, presentation, and control

Observer Pattern: Real-time UI updates when cart changes

Singleton Pattern: For database connection and shared resources
