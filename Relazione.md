# <p align="center">Complex Network Analysis</p>

Introduzione

In questa relazione interpreto i risultati ottenuti con due librerie di Java (JGraphT e Jung) e Gephi riguardanti l’analisi della rete
Twitch Social Network (EN).
La rete presa in esame è un grafo non diretto che è stato creato in seguito all'analisi delle amicizie fra gli streamers inglesi della piattaforma Twitch.
Ogni nodo rappresenta uno streamer e ogni arco, l'amicizia fra due streamers.
La rete non è pesata (peso su ogni arco è uguale ad 1 di default).

Visualizzazione

La rete è stata rappresentata con il tool Gephi usando il layout ForceAtlas 2.

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/network.png"/>
</p>

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

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/distance_distribution.png"/>
</p>

Considerazioni:
Si nota subito la presenza del fenomeno del mondo piccolo dato che la media delle distanze è molto bassa.

3. Grado
Grado medio: 9.914
Varianza: 492.40

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/degree_distribution.png"/>
</p>

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

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/degree_centrality.png"/>
</p>

● Closeness Centrality:

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/closeness_centrality.png"/>
</p>

● Harmonic Closeness Centrality:

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/harmonic_closeness_centrality.png"/>
</p>

● Eigenvector Centrality:

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/eigenvector_centrality.png"/>
</p>

● Betweenness Centrality:

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/betweeness_centrality.png"/>
</p>

● PageRank:

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/page_rank_centrality.png"/>
</p>

● HITS Score:

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/hits_authorities_centrality.png"/>
</p>

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/hits_hubs_centrality.png"/>
</p>

P.S. Per qunto riguarda il calcolo del PageRank e dell'algoritmo HITS, è stato utilizzato un dumping factor pari a 0.20.
Invece per quanto riguarda PageRank, Eigenvetor Centrality e HITS, essendo per natura degli algoritmi che effettuano delle approssimazioni successive, è stato settato un limite di 1000 iterazioni massime.

Transitività (coefficiente di clustering globale, percentuale di triangoli): 0.14

Considerazioni:
La correlazione tra In Degree e PageRank è forte, 0.84, questo ci indica che se un nodo
ha un grado in ingresso elevato, è molto probabile conoscerlo tramite amici di amici.
La correlazione tra Hubs e Authority è forte, 0.76, questo ci indica che più amici ha un
nodo più è amico di altri, quindi più vota più viene votato.
La correlazione tra In Degree e Harmonic Closeness è moderata, 0.65, quindi un nodo
con grado in ingresso elevato probabilmente si trova vicino al resto della rete (quindi sta
al centro).
La correlazione tra Page Rank e Harmonic Closeness è moderata, 0.58, quindi i nodi al
centro della rete probabilmente sono tra i più famosi della scuola.
La transitività bassa fa pensare che due persone con un migliore amico in comune non
si considerino migliori amiche, dato che ci sono pochi triangoli.

## AUTORE

* **Alberto Guastalla** - [AlbertoGuastalla](https://github.com/AlbertoGuastalla)
