# <p align="center">Complex Network Analysis</p>

Introduzione

In questa relazione interpreto i risultati ottenuti con tre librerie di Java (JGraphT, Jung e GraphStream) e Gephi riguardanti l’analisi della rete
Twitch Social Network (EN).
La rete presa in esame è un grafo non orientato che è stato creato in seguito all'analisi delle amicizie fra gli streamers inglesi della piattaforma Twitch.
Ogni nodo rappresenta uno streamer e ogni arco, l'amicizia fra due streamers.
La rete non è pesata (peso su ogni arco è uguale ad 1 di default).

Visualizzazione

La rete è stata rappresentata con il tool Gephi usando il layout Yifan Hu.

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/network.png"/>
</p>

Considerazioni

La rete così visualizzata sembra avere gruppo compatto di streamers al centro con tanti outlier posizionati sulla "cresta" del grafo.

Misure

1. Generiche
è un grafo non orientato
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

Il grafico mostra una marcata pendenza, in particaolare si capisce subito che l’assortatività della rete è
negativa, ciò è anche confermato dal coefficiente angolare della retta che è negativo.
Possiamo quindi concludere che è presente un segnale di omofilia inversa o disassortatività rispetto al grado dei nodi.
Questo risultato è possibile verificarlo, osservando direttamente il grafico in cui si nota subito che, spostandosi dal centro alla periferia, il grado dei nodi va man mano diminuendo.

Struttura

1. Componenti
Essendo un grafo non orientato, esso è fortemente connesso.

2. Eccentricità
È la massima distanza tra un nodo e tutti gli altri nodi della rete.
Permette di misurare quanto ogni nodo si trova lontano dal centro della rete.
La distanza tra due nodi è la lunghezza del cammino più breve che li collega.
Diametro della rete: 10 (eccentricità più grande)
Raggio della rete: 6 (eccentricità più piccola)
Numero di nodi facenti parte del sottografo indotto dai vertici la cui eccentricità è massima: 5
Numero di nodi facenti parte del sottografo indotto dai vertici la cui eccentricità è minima: 1115

Considerazioni:
Dato il grafo non è orientato, è stato possibile calcolare l’eccentricità dei
suoi nodi.
Il numero di nodi che possiedono il valore di eccentricità pari al raggio del grafo sono molti; questo è una conferma sul fatto che gran parte dei nodi del grafo siano posizionati al centro del grafo stesso.

3. Core e periferia
Una rete sociale è formata da 2 tipi di nodi:
● core (i nodi che sono più o meno strettamente interconnessi)
● periferia (i nodi che sono strettamente collegati al core, ma solo debolmente tra loro)

Nodi del core: 1153 (k-core con k=10)
Archi del core: 12782
Nodi della periferia: 5973

Considerazioni:
Il core è localizzato nel cuore della rete, mentre la periferia è composta dei nodi che fluttuano all'esterno del core.

Community
La modularità m è la differenza tra:
- la frazione degli archi che ricadono all'interno delle comunità date e
- la frazione attesa se gli archi fossero distribuiti in modo casuale
(conservando i gradi dei nodi)
Il valore di m è compreso tra -0,5 (incluso) e 1 (escluso):
- Se la maggior parte degli archi è incidente ai nodi all'interno della stessa comunità, la
modularità è molto alta, vicina (ma non uguale) a 1 e la partizione proposta descrive una
struttura della comunità molto buona.
- La modularità di -0.5 significa che i nodi all'interno della stessa comunità non sono
affatto adiacenti, la struttura della comunità proposta è peggiore di quella casuale.

Algoritmo di Gephi (Blondel Guillaume Lefebvre based on modularity score)
Parametri:
Risoluzione: 1.0
Randomizzazione: Si
Risultati:
Modularità: 0.451
Numero comunità rilevate: 16

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/communities.png"/>
</p>

Risoluzione: 2.0
Risultati:
Modularità: 0.37
Numero comunità rilevate: 3

Considerazioni:
Con una più bassa risuluzione l'algoritmo trova meno communities ma più coese (anche se la modularità è leggermente più bassa).

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/communities1.png"/>
</p>

Modelli causali

Barabasi-Albert model
● Parametri:
- numero nodi: 7126
- numero di archi: 39675

● Analisi
○ grafo non orientato
○ Densità: 0.002
○ Distanza media: 3.481
○ Varianza della distanza: 0.447
○ Grado medio: 11.135
○ Varianza del grado: 260.08
○ Clustering Coefficient: 0.014
○ Assortatività (grado):
Coefficiente: -0.03646606436
○ Componenti:
Il grafo è connesso
Il numero di componenti connesse è 1
○ Algoritmo di Gephi (Blondel Guillaume Lefebvre based on modularity score):
Il numero di comunità rilevate è: 20
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è ancora più compatto (in termini di centralità dei nodi) del grafo preso in esame.
E' parzialmente presente il fenomeno del mondo piccolo dato che la distanza media è 3.481, ma il coefficiente di clustering non è così elevato rapportato alla densità del grafo.
La distribuzione del grado segue una power law proprio come il grafo analizzato nella prima parte, infatti il grado presenta un'elevata variabilità.
Il grafo sembra essere neutrale/disassortativo, infatti il suo coefficiente è
negativo ma è piuttosto vicino a 0.
Non essendo diretto ed essendo connesso, ovviamente c’è una sola componente gigante che
contiene tutti i nodi.

Erdos-Renyi model (gnp model)
● Parametri
Numero nodi: 7126
Numero archi: 35633
● Analisi
○ grafo non orientato
○ Densità: 0.001
○ Distanza media: 4.107
○ Varianza della distanza: 0.452
○ Grado medio: 10.001
○ Varianza del grado: 9.868
○ Clustering Coefficient: 0.001
○ Assortatività (grado):
Coefficiente: -0.009384953056
○ Componenti:
Il grafo è connesso
Il numero di componenti connesse è 1
○ Comunità (Algoritmo Louvain):
Il numero di comunità rilevate è: 21
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è ancora più compatto (in termini di centralità dei nodi) di quello generato dal modello di Barabasi-Albert.
E' parzialmente presente il fenomeno del mondo piccolo dato che la distanza media è 4.107, ma il coefficiente di clustering risulta essere uguale alla densità del grafico.
La distribuzione del grado non segue una power law, quindi assumiamo che non sia
presente il fenomeno rich get richer, questo inoltre è confermato dalla non eccessiva variabilità del grado dei nodi.
Il grafo sembra essere neutrale/disassortativo, infatti il suo coefficiente è
negativo ma è vicinissimo a 0.
Non essendo diretto ed essendo connesso, ovviamente c’è una sola componente gigante che
contiene tutti i nodi.

Watts-Strogatz model (gnp model)
● Parametri
Numero nodi: 7126
Numero archi: 35630
● Analisi
○ grafo non orientato
○ Densità: 0.001
○ Distanza media: 4.323
○ Varianza della distanza: 0.484
○ Grado medio: 9.999
○ Varianza del grado: 3.721
○ Clustering Coefficient: 0.088
○ Assortatività (grado):
Coefficiente: -0.04873289853
○ Componenti:
Il grafo NON è connesso
○ Comunità (Algoritmo Louvain):
Il numero di comunità rilevate è: 55
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è ancora più compatto (in termini di centralità dei nodi) di quello generato dal modello di Barabasi-Albert.
E' presente il fenomeno del mondo piccolo dato che la distanza media è 4.323, ed il coefficiente di clustering risulta essere addirittura 88 volte più grande della densità del grafo.
La distribuzione del grado non segue una power law, quindi assumiamo che non sia
presente il fenomeno rich get richer, questo inoltre è confermato dalla non eccessiva variabilità del grado dei nodi.
Il grafo sembra essere neutrale/disassortativo, infatti il suo coefficiente è
negativo ma è vicinissimo a 0.
Non essendo diretto ed essendo connesso, ovviamente c’è una sola componente gigante che
contiene tutti i nodi.

## AUTORE

* **Alberto Guastalla** - [AlbertoGuastalla](https://github.com/AlbertoGuastalla)
