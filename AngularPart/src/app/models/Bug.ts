export interface Bug {
  id?: number;
  title: string;
  description: string;
  creationdate: Date;
  devid: number;
  priority: string;
  state: string;
}