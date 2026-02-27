# Vegetable Store POS System

A comprehensive Point-of-Sale desktop application designed specifically for vegetable retail stores, built with Java Swing and object-oriented programming principles.

## 📋 Overview

The Vegetable Store POS System is a robust desktop application that streamlines the billing and inventory management process for small to medium vegetable retail shops. It provides an intuitive interface for cashiers to quickly process customer purchases, calculate totals in real-time, and generate accurate receipts. The system allows users to select products, enter quantities, automatically calculate prices, and display order items dynamically in a table. It follows a modular and structured design based on object-oriented programming principles, separating the GUI, models, and business logic for maintainability and scalability.

## ✨ Key Features

### 🧾 Receipt Management
- Dynamic receipt generation with customer details and itemized purchases
- Real-time total calculations as items are added
- Save receipts or dismiss transactions with ease

### 👥 Customer Information
- Capture customer full name and phone number
- Store delivery/pickup location details
- Maintain customer records for future reference

### 🥦 Product Selection
- Display current vegetable prices
- Flexible quantity entry (KG/Unit based)
- Multi-item support for single transactions
- Real-time item counter showing total items in cart

### 💰 Price Calculation
- Automatic price computation based on quantity
- Running total display with decimal support
- Transparent pricing with itemized breakdown

### 📊 Order Display
- Tabular view with:
  - Product ID
  - Type/Name
  - Quantity
  - Individual Price
- Clean, organized layout for easy verification

## 🏗️ Architecture

The application follows a clean, modular architecture based on Object-Oriented Programming principles:
├── GUI Layer # Swing components for user interaction
├── Models Layer # Data structures for Products, Customers, Receipts
├── Business Logic # Price calculation, validation, receipt generation
└── Utils # Helper classes for formatting and utilities

### Design Patterns Implemented
- **MVC Pattern**: Separation of concerns between data, presentation, and control
- **Observer Pattern**: Real-time UI updates when cart changes
- **Singleton Pattern**: For database connection and shared resources

- <img width="1468" height="833" alt="Screenshot 2026-02-27 at 12 28 52 AM" src="https://github.com/user-attachments/assets/bc7865f2-c0e2-4bd9-85b0-7eed64bca60b" />
