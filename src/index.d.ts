import type { EmitterSubscription } from "react-native";

export type SunmiPaymentPrimitive = boolean | number | string | null;
export type SunmiPaymentValue =
  | SunmiPaymentPrimitive
  | SunmiPaymentObject
  | SunmiPaymentValue[];

export interface SunmiPaymentObject {
  [key: string]: SunmiPaymentValue;
}

export interface SunmiPaymentEvent {
  operation: string;
  eventCode: number;
  eventData: string | null;
}

export type SunmiPaymentParams = Record<string, unknown>;

export interface SunmiPaymentModule {
  connect(params?: SunmiPaymentParams | null): Promise<boolean>;
  disconnect(): void;
  isConnected(): Promise<boolean>;
  init(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  historyInquiry(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  batch(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  getMerchantInfo(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  purchase(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  voidTransaction(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  independentRefund(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  refund(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  preAuthorization(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  capture(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  forceAuthorization(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  tipAdjustment(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  incrementalAuthorization(
    params?: SunmiPaymentParams | null
  ): Promise<SunmiPaymentValue>;
  cardAuthentication(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  balanceInquiry(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  transactionCancel(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  applySignature(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  getSignature(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  reprint(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  readCard(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  pinPad(params?: SunmiPaymentParams | null): Promise<SunmiPaymentValue>;
  addListener(listener: (event: SunmiPaymentEvent) => void): EmitterSubscription;
  removeAllListeners(): void;
}

export const EVENT_NAME: "SunmiPaymentEvent";
export const SunmiPayment: SunmiPaymentModule;
export function addSunmiPaymentListener(
  listener: (event: SunmiPaymentEvent) => void
): EmitterSubscription;
export function removeAllSunmiPaymentListeners(): void;

export default SunmiPayment;
