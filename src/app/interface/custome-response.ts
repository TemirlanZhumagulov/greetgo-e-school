import { Student } from "./student";

export interface CustomResponse{
  timeStamp: Date;
  statusCode: number;
  status: string;
  reason: string;
  message: string;
  developerMessage: string;
  data: { students?: Student[], student?: Student };
}

