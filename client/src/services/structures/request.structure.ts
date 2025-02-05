export interface IRequest<Request, Response> {
  send(input: Request): Promise<Response | undefined>;
}
