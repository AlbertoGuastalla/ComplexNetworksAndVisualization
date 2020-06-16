# <p align="center">Complex Network Analysis</p>

Introduzione

In questa relazione interpreto i risultati ottenuti con due librerie di Java (JGraphT e Jung) e Gephi riguardanti l’analisi della rete
Twitch Social Network (EN).
La rete presa in esame è un grafo non diretto che è stato creato in seguito all'analisi delle amicizie fra gli streamers inglesi della piattaforma Twitch.
Ogni nodo rappresenta uno streamer e ogni arco, l'amicizia fra due streamers.
La rete non è pesata (peso su ogni arco è uguale ad 1 di default).

Visualizzazione

La rete è stata rappresentata con il tool Gephi usando il layout ForceAtlas 2.

IMMAGINE

Considerazioni

La rete così visualizzata sembra avere gruppo di streamers con tanti outlier posizionati sulla "cresta" del grafo.

Misure

1. Generiche
è un grafo non diretto
NON è un multigrafo
NON sono presenti selfloops
NON sono presenti nodi isolati

Numero di Nodi: 7126
Numero di Archi: 35324
Numero di archi possibili: 50772750
Densità: 0.07% (archi presenti / archi possibili)
Considerazioni
La densità è bassissima.
Da una prima e rapida analisi infatti, si nota la presenza di molti nodi con un grado basso e pochi nodi con un grado alto (hubs).
Questa caratteristica è molto ricorrente nelle free-scale network in cui vi è una distribuzione esponenziale negativa del grado dei nodi (es. preferential attachment model).

2. Distanza
Distanza media: 3.677
Varianza: 0.735
Diametro: 10
Distribuzione:

IMMAGINE

Considerazioni:
Si nota subito la presenza del fenomeno del mondo piccolo dato che la media delle distanze è molto bassa.

3. Grado
Grado medio: 9.914
Varianza: 492.40

IMMAGINE

Considerazioni
Come sovracitato, il grafo segue una legge di potenza (almeno asintoticamente) e come si puo’ vedere nella
versione logaritmica esso segue una retta.
Cio’ vuol dire che la rete e’ nel regime libero da scala ed e’ presente il fenomeno rich get richer.
Cio’ indica la presenza di hub che potrebbero essere formati dagli streamers piu’ popolari della piattaforma Twitch.
P.S. Per il calcolo dei due momenti, è stato utilizzato l'algoritmo online one pass di Wellford per avere una maggiore stabilità numerica.

4. Centralità
Le misure di centralità permettono di identificare i nodi più importanti all’interno della rete.
Abbiamo considerato diverse misure di centralità:

● Degree Centrality:
● Closeness Centrality:
● Harmonic Closeness Centrality:
● Eigenvector Centrality:
● Betweenness Centrality:
● PageRank:
● HITS Score:

## AUTORE

* **Alberto Guastalla** - [AlbertoGuastalla](https://github.com/AlbertoGuastalla)
