class Solution(object):
    def maxBottlesDrunk(self, numBottles, numExchange):
        nbottledrink=numBottles
        while numBottles>=numExchange:
            while numBottles>=numExchange:
                numBottles=numBottles-numExchange+1
            
                nbottledrink+=1
                numExchange+=1
        return nbottledrink
        
