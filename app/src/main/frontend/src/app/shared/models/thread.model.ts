export interface Thread {
  idThread: number;
  title: string;
  bidId: number | null;
  peerId: number | null;
  peerFirstName: string | null;
  peerLastName: string | null;
  lastMessage: string | null;
  lastMessageAt: string | null;
}
