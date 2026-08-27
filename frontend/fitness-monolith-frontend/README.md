# PulseFit Frontend

A polished React + Vite frontend designed specifically for the Fitness Monolith backend.

## Features
- JWT sign in and registration
- Activity logging with all backend activity types
- Activity dashboard using `/api/activities`
- Calories, duration, activity and streak summaries
- Recommendation creation and retrieval
- Responsive desktop/mobile UI
- Light/dark mode

## Run locally

```bash
npm install
cp .env.example .env
npm run dev
```

The default API is the deployed backend:

`https://fitness-mono-bs2k.onrender.com`

## Important backend integration

The frontend sends:

- `Authorization: Bearer <JWT>` for protected endpoints
- `X-User-ID: <userId>` when fetching `/api/activities`
- `ActivityId` when generating recommendations, matching the backend request DTO JSON property

If the deployed backend is accessed from a different frontend domain, Spring Boot must allow that origin through CORS. Add a global CORS configuration or equivalent `CorsConfigurationSource` to the backend if the browser reports a CORS error.
