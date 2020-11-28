import { NativeModules } from 'react-native';

type RnorderprinterType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Rnorderprinter } = NativeModules;

export default Rnorderprinter as RnorderprinterType;
