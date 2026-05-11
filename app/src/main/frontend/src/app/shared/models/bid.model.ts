// Modele Bid : reflete le BidDto envoye par le backend
export interface Bid {
  idBid: number;
  title: string;
  description: string;
  price: number | null;
  creationDate: string;
  userId: number;
  userFirstName: string;
  userLastName: string;
}


