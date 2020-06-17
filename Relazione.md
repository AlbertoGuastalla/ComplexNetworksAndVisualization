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

Considerazioni:
I grafici mostrano lo score dei primi 50 vertici del grafo in ordine dcrescente di score.
Come è possibile osservare, vi sono sempre i nodi 1773 e 4949 in testa ad ogni grafico, il che porta a pensare che essi rappresentino i nodi maggiormente "influenti" della rete.
In tutti i grafi (ad eccezione dei due tipi di closeness centrality), si può notare un andamento esponenziale (tipico delle reti libere da scala, come già accennato prima).
Nei due grafici rimanenti invece, questo comportamento "esponenziale" non è così evidente come nei casi precedenti a causa della conformazione del grafo; in altre parole, essendo la distanza media molto bassa, i vertici del grafo tendono ad essere molto vicini l'uno dall'altro e quindi gli scores di queste centrality (dei primi 50 nodi della rete) risultano essere molto simili.

Clustering Coefficient

Global Transitivity: 0.042
Local Transitivity: 0.130

Considerazioni:
Anche se basso il coefficient di clustering risulta almeno 60 volte più grande della densità dell'intero grafo.
Quindi ricapitolando, il grafo è caratterizzato da un bassissimo average path length e da un elevato clustering coeeficient (rapportato alla densità del grafo), il che porta a concludere (in accordo con la teoria) che il grafo abbia la proprietà di "Small World".

Assortatività (omofilia)
Permette di misurare il grado di correlazione tra i valori degli attributi dei nodi.
Una rete è assortativa se i nodi tendono a connettersi a nodi con valori simili (rispetto a un attributo).
In pratica permette di analizzare l'omofilia (se è assortativo rispetto a un valore c'è omofilia).
Correlazione tra il grado di un nodo e il grado medio dei suoi vicini
Non avendo attributi sui nodi, è stato usato il grado: verifichiamo se i nodi con tanti archi
tendono a collegarsi ad altri nodi con tanti archi.
La pendenza della retta indica se c’è assortatività o meno:
- positiva: assortativo
- negativa: disassortativo

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/degree_correlation.png"/>
</p>

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/omophily.png"/>
</p>

Coefficiente di assortatività del grado: -0.336005892
Considerazioni

Il grafico mostra una marcata pendenza, quindi significa che l’assortatività della rete è
negativa, ciò è anche confermato dal coefficiente angolare della retta che è negativo.
Possiamo quindi concludere che è presente un segnale di omofilia inversa o disassortatività rispetto al grado dei nodi.

## AUTORE

* **Alberto Guastalla** - [AlbertoGuastalla](https://github.com/AlbertoGuastalla)
