class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        nbottledrink=numBottles
        while numBottles>=numExchange:
            numBottles=numBottles-numExchange+1
            nbottledrink+=1
        return nbottledrink
        
