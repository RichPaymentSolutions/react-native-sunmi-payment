# `@richpaymentsolutions/react-native-sunmi-payment`

React Native **Android-only** package for the Sunmi payment SDK.

The native implementation stays in this repo (`core/` + `react-native-bridge/`), and the package surface now adds:

- `package.json` + JS entrypoint
- `react-native.config.js` for Android autolinking
- `android/` package module that reuses the existing native sources

## Install in another React Native app

Use a local path, git dependency, or publish/install it from GitHub Packages.

> **Note**
> GitHub Packages does not support **public npm packages for organization scopes**. For `@richpaymentsolutions/...`, the GitHub npm package will remain private and requires authentication to install. If you need public npm distribution, publish the same package to **npmjs.com** instead.

### Local path

```bash
bun add ../sunmi-payment-android
```

### Git

```bash
bun add git+ssh://git@github.com/RichPaymentSolutions/react-native-sunmi-payment.git
```

### GitHub Packages

In the consuming app's `~/.npmrc` or project `.npmrc`:

```properties
@richpaymentsolutions:registry=https://npm.pkg.github.com
//npm.pkg.github.com/:_authToken=${GITHUB_TOKEN}
always-auth=true
```

Then authenticate the shell from GitHub CLI:

```bash
export GITHUB_TOKEN="$(gh auth token)"
```

Then install:

```bash
bun add @richpaymentsolutions/react-native-sunmi-payment
```

## Team setup after pulling this repo

This repo already includes a checked-in `.npmrc` with the correct scope mapping, so teammates do **not** need to edit registry config in this package repository.

They only need:

```bash
cd sunmi-payment-android
export GITHUB_TOKEN="$(gh auth token)"
bun run auth:github
bun run verify:android
```

Available helper scripts:

- `bun run auth:github` — verify GitHub Packages authentication
- `bun run verify:android` — build the Android library module
- `bun run publish:github` — publish to GitHub Packages

## Android requirements

1. React Native 0.73+ recommended
2. `minSdkVersion` 24+
3. Java 17 / AGP 8 compatible Android build

Ensure the host app resolves the Sunmi SDK dependency. If your `android/settings.gradle` uses `dependencyResolutionManagement`, include:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://s01.oss.sonatype.org/content/groups/public/")
    }
}
```

If your host app uses a different React Native version, add this to `android/gradle.properties` in the host app:

```properties
reactNativeVersion=0.73.6
```

The package autolinks on Android, so you do **not** need to manually add `SunmiPaymentPackage` in `MainApplication`.

If you use Expo, this package requires an **Android development build** or release build. It will not work inside **Expo Go** because Expo Go cannot load custom native modules.

## JavaScript usage

```javascript
import {
  SunmiPayment,
  addSunmiPaymentListener,
} from '@richpaymentsolutions/react-native-sunmi-payment';

const subscription = addSunmiPaymentListener(event => {
  console.log('Sunmi payment event', event);
});

await SunmiPayment.connect({ connectType: 'ON_DEVICE' });
const connected = await SunmiPayment.isConnected();
const result = await SunmiPayment.purchase({
  amount: 1250,
  paymentType: 'CREDIT',
  printReceipt: true,
});

console.log({ connected, result });
subscription.remove();
```

## Available methods

- `connect`
- `disconnect`
- `isConnected`
- `init`
- `historyInquiry`
- `batch`
- `getMerchantInfo`
- `purchase`
- `voidTransaction`
- `independentRefund`
- `refund`
- `preAuthorization`
- `capture`
- `forceAuthorization`
- `tipAdjustment`
- `incrementalAuthorization`
- `cardAuthentication`
- `balanceInquiry`
- `transactionCancel`
- `applySignature`
- `getSignature`
- `reprint`
- `readCard`
- `pinPad`

All request payloads are passed as plain JS objects matching the Java setter names on the native request models.

Examples:

- `purchase({ amount, paymentType, tip, tax, printReceipt, orderId })`
- `refund({ oriOrderId, oriTransactionId, printReceipt, orderId })`
- `preAuthorization({ amount, tax, printReceipt, orderId })`
- `readCard({ readCardTypes: [1, 2, 4], timeout, orderId })`

Amounts are expected in **cents**.

## Events

- event name: `SunmiPaymentEvent`
- payload: `{ operation, eventCode, eventData }`

## Package structure

- `src/` — JS/TS package exports
- `android/` — Android module used by React Native autolinking
- `core/` — native Sunmi payment wrapper
- `react-native-bridge/` — React Native bridge source reused by `android/`

## Validate the Android package locally

From this repo root:

```bash
./gradlew :android:assembleRelease
```

## Publish to GitHub Packages

Create the target repository first:

```bash
gh repo create RichPaymentSolutions/react-native-sunmi-payment --public --description "React Native Android bridge for the Sunmi payment SDK."
```

Publish from this package directory with a token that has `write:packages`:

```bash
cd sunmi-payment-android
export GITHUB_TOKEN="$(gh auth token)"
bun run publish:github
```

This publishes the package to GitHub Packages under the `richpaymentsolutions` scope, but the package remains **private** because GitHub does not allow public organization-scoped npm packages.
