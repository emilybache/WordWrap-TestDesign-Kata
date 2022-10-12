# Typescript implementation

See the [description of the Kata](../README.md)

It a mechanical port of the java implementation.
- `WordWrapKoflerLoopBuffer` was not implemented because TypeScript does not have StringBuilder

## Run tests

Unit tests with jest runner

```shell
npm test
```

Other testing scripts

```shell
# Unit test with jest runner in watch mode
npm run test:watch

# Unit tests with vitest runner in watch mode
npm run:test:vitest

# Unit tests with branch coverage
npm run test:coverage

# Mutation testing with stryker-mutator
npm run test:mutation
```