import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import RnOrderPrinter from 'rnorderprinter';

export default function App() {
  const [result, setResult] = React.useState<boolean | undefined>();

  React.useEffect(() => {
    const html = `<html><body><h2>Test test</h2></body></html>`
    RnOrderPrinter.printHtml(html).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
