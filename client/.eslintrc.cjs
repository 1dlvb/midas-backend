module.exports = {
  root: true,
  env: { browser: true, es2020: true },
  extends: [
    "airbnb",
    "airbnb-typescript",
    'eslint:recommended',
    'plugin:@typescript-eslint/recommended',
    'plugin:react-hooks/recommended',
    "plugin:prettier/recommended",
    "prettier"
  ],
  parserOptions: {
    project: ["./tsconfig.json", "./tsconfig.node.json"],
    tsconfigRootDir: __dirname,
    sourceType: "module",
  },
  ignorePatterns: ['dist', '.eslintrc.cjs'],
  parser: '@typescript-eslint/parser',
  plugins: ['react-refresh', "@typescript-eslint", "prettier"],
  settings: {
    "react": {
      "version": "detect",
    },
    "import/resolver": {
      "alias": {
        "map": [
          [
            "~",
            "./src"
          ]
        ],
        "extensions": [
          ".js",
          ".ts",
          ".tsx",
          ".d.ts",
          ".test.ts",
          ".json"
        ]
      }
    }
  },
  rules: {
    "import/extensions": [
      "error",
      "ignorePackages",
      {
        "js": "never",
        "jsx": "never",
        "ts": "never",
        "tsx": "never",
        "": "never"
      }
    ],
    'react-refresh/only-export-components': [
      'warn',
      { allowConstantExport: true },
    ],
    "react/react-in-jsx-scope": "off",
    "react/button-has-type": "off",
    "no-duplicate-imports": "error",
    "no-unreachable-loop": "error",
    "camelcase": "warn",
    "eqeqeq": "warn",
    "no-console": "warn",
    "max-len": ["warn", { "code": 100 }],
    "@typescript-eslint/no-unused-vars": "warn",
  },
}
