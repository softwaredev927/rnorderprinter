import { NativeModules } from 'react-native';

type RnOrderPrinterType = {
  printHtml(htmlData: string): Promise<boolean>;
};

const { RnOrderPrinter } = NativeModules;

export default RnOrderPrinter as RnOrderPrinterType;
