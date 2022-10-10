import { defineConfig } from 'vitest/config'

export default defineConfig({

    test: {
        // enable global imports (it, describe, expect ...)
        // This way we can run tests with either jest or vitest indifferently
        globals:true
    },
})
