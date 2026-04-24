module.exports = {
  dependency: {
    platforms: {
      android: {
        sourceDir: "./android",
        packageImportPath:
          "import com.richpayment.sunmipayment.reactnative.SunmiPaymentAutolinkPackage;",
        packageInstance: "new SunmiPaymentAutolinkPackage()",
      },
      ios: null,
    },
  },
};
