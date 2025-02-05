import axios, { AxiosResponse } from "axios";

const api = axios.create({
  baseURL: "http://localhost:8081",
});

api.interceptors.response.use((response: AxiosResponse) => {
  if (response.status >= 400) {
    throw new Error(response.data.message);
  }
  return response;
});

export default api;
