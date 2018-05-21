
# coding: utf-8

# In[139]:


import pandas as pd
data = pd.read_csv('samples.csv',names = ['A','B','C','D','E','F','G'])
a = data.groupby('A').size()/len(data)
b = data.groupby('B').size()/len(data)
c = data.groupby('C').size()/len(data)
d = data.groupby('D').size()/len(data)
e = data.groupby('E').size()/len(data)
f = data.groupby('F').size()/len(data)
g = data.groupby('G').size()/len(data)


# In[140]:


(data.groupby(['A', 'B']).size()/len(data))/a


# In[141]:


(data.groupby(['A', 'C']).size()/len(data))/a


# In[142]:


(data.groupby(['B', 'C']).size()/len(data))/b


# In[143]:


(data.groupby(['C', 'D']).size()/len(data))/c


# In[144]:


(data.groupby(['D', 'E']).size()/len(data))/d


# In[145]:


(data.groupby(['E', 'F']).size()/len(data))/e


# In[146]:


(data.groupby(['F', 'G']).size()/len(data))/f


# In[147]:


import pomegranate
pa = DiscreteDistribution({'T': 0.6999, 'F': 0.3001})
pb = DiscreteDistribution({'T': 0.4004, 'F': 0.5996})
pc = DiscreteDistribution({'T': 0.4654, 'F': 0.5346})
pd = DiscreteDistribution({'T': 0.8070, 'F': 0.1930})
pe = DiscreteDistribution({'B': 0.4797, 'M': 0.3000, 'T': 0.2203})
pf = DiscreteDistribution({'T': 0.8225, 'F': 0.1775})
pg = DiscreteDistribution({'T': 0.0831, 'F': 0.9169})


# In[150]:


sa = State( pa, name="A" )
sb = State( pb, name="B" )
sc = State( pc, name="C" )
sd = State( pd, name="D" )
se = State( pe, name="E" )
sf = State( pf, name="F" )
sg = State( pg, name="G" )
model = BayesianNetwork( "1000000 Problem" )
#all nodes are independent
model.add_states(sa, sb, sc, sd, se, sf, sg)
model.add_transition(sa, sb)
model.add_transition(sb, sc)
model.add_transition(sc, sd)
model.add_transition(sd, se)
model.add_transition(se, sf)
model.add_transition(sf, sg)
model.bake()


# In[151]:


print (model.probability(['T', 'T', 'T', 'T', 'T', 'T', 'T']))

