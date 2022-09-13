## 0-1 Knapsack -- Recursion
Given a knapsack which can hold s pounds of items, and a set of items with weight w1, w2, ... wn. Return whether we can pick specific items so that their total weight s.

Example input: s= 20; w= [14,8,7,5,3];

Example Output: True

## Knapsack -- find all results of target number
Given a set of weights numbers (W) and a target number(T), find all unique combinations in W where the weights numbers sums to T.

question: 
1. Are all weights numbers unique?
2. Can the same number be chosen multiple times(unlimited times)?
3. at least one result be returned?

Example input: target= 25; weights= [14,8,7,5,3];

Example Output: 

[[14, 8, 3], [14, 5, 3, 3], [8, 8, 3, 3, 3], [8, 7, 7, 3], [8, 7, 5, 5], [8, 5, 3, 3, 3, 3], [7, 7, 5, 3, 3], [7, 5, 5, 5, 3], [7, 3, 3, 3, 3, 3, 3], [5, 5, 5, 5, 5], [5, 5, 3, 3, 3, 3, 3]]