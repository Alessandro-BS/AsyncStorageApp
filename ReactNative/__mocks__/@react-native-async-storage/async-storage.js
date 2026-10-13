// Mock en memoria de AsyncStorage para los tests de Jest
const store = new Map();

module.exports = {
  __esModule: true,
  default: {
    setItem: jest.fn(async (key, value) => {
      store.set(key, value);
    }),
    getItem: jest.fn(async key => (store.has(key) ? store.get(key) : null)),
    removeItem: jest.fn(async key => {
      store.delete(key);
    }),
    clear: jest.fn(async () => {
      store.clear();
    }),
  },
};
