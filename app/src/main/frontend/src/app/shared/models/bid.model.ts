// Modele Bid : reflete le BidDto envoye par le backend
export interface Bid {
  idBid: number;
  title: string;
  description: string;
  creationDate: string;
  userId: number;
}
