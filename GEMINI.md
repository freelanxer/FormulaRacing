# FormulaRacing 專案開發指南

## 1. 專案概觀 (Project Overview)
<!-- 在這裡簡述這個 App 的主要功能、目標使用者等 -->

## 2. 技術棧與架構 (Tech Stack & Architecture)
- **主要語言**: Kotlin
- **UI**: Jetpack Compose
- **架構模式**: MVVM (Model-View-ViewModel)
- **非同步處理**: Kotlin Coroutines & Flow
- **依賴注入**: Koin
- **網路請求**: Retrofit
- **資料庫**: Room (如果有的話)
- **其他重要函式庫**:

## 3. 常用指令 (Common Commands)
- **編譯並安裝 (Debug)**: `./gradlew installDebug`
- **執行單元測試**: `./gradlew testDebugUnitTest`
- **執行 UI 測試**: `./gradlew connectedDebugAndroidTest`
- **執行 Lint 檢查**: `./gradlew lintDebug`
- **更新依賴版本**: (例如 `./gradlew versionUpdates`)

## 4. 套件職責說明 (Package Responsibilities)
<!-- 說明主要 package 的用途，幫助我理解程式碼結構 -->
- **`data/remote`**: 處理所有遠端 API 請求。
- **`data/local`**: 處理本地資料庫 (Room) 相關操作。
- **`di`**: 放置依賴注入 (Dependency Injection) 的模組。
- **`model`**: 定義資料模型，區分 UI Model 和 Entity。
- **`ui/screen`**: 存放各個畫面的 Composable 函式與對應的 ViewModel。
- **`ui/component`**: 存放可跨畫面共用的 Composable UI 元件。
- **`navigation`**: 管理畫面間的導航邏輯 (Navigation)。

## 5. 開發準則 (Development Guidelines)
- **UI 開發**:
    - 所有顏色、字體樣式應定義在 `ui/theme` 目錄下。
    - 可預覽的 Composable 應加上 `@Preview`。
    - 避免在 Composable 函式中直接處理複雜的業務邏輯。
- **ViewModel**:
    - 應繼承 `androidx.lifecycle.ViewModel`。
    - 使用 `StateFlow` 或 `SharedFlow` 向 UI 層暴露狀態。
    - 透過建構子注入 (Constructor Injection) 取得 Repository。
- **資料層 (Data Layer)**:
    - Repository 應作為唯一入口 (Single Source of Truth)。
    - API 回應應使用 `ApiResult` 類進行封裝，以處理成功、失敗、載入中等狀態。
- **資源管理**:
    - 所有字串應定義在 `res/values/strings.xml`。
    - 圖片資源應根據解析度放置在對應的 `drawable-` 或 `mipmap-` 目錄。

## 6. 溝通方式 (Communication Style)
- 使用繁體中文、台灣用語與開發者溝通。