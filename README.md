# File to refactor https://github.com/MariaIvanova01/GreedyTimes/blob/FileToRefactor/GreedyTimes/src/workingWithAbstraction/greedyTimes/Main.java

# GreedyTimes

Finally, you have unlocked the safe and reached the treasure! Inside there are all kinds of gems, cash in different currencies, and gold bullions. Next to you, there is a bag which unfortunately has limited space. You don’t have much time so you need to take as much wealth as possible! But to get a bigger amount of the most valuable items, you need to keep the following rules:

•	The gold amount in your bag should always be more than or equal to the gem amount at any time

•	The gem amount should always be more than or equal to the cash amount at any time

If you read an item that breaks one of these rules you should not put it in the bag. You should always be careful not to exceed the overall bag’s capacity because it will tear down and you will lose everything! You will receive the content of the safe on a single line in the format "{item} {quantity}" pairs, separated by 
whitespace.

You need to gather only three types of items:

•	Cash - All three letter items 

•	Gem - All items which end on "Gem" (at least 4 symbols)

•	Gold - this type has only one item with the name - "Gold"

Each item that does not fall in one of the above categories is useless and you should skip it. Reading item’s names should be CASE-INSENSITIVE, except when the item is Cash. You should aggregate items’ quantities that have the same name.

If you’ve kept the rules you should escape successfully with a bag full of wealth. Now it’s time to review what you have managed to get out of the safe. Print all the types ordered by the total amount in descending order. Inside a type, order the items first alphabetically in descending order and then by their amount in ascending 
order. Use the format described below for each type.

Input
------

•	On the first line, you will receive a number that represents the capacity of the bag.

•	On the second line, you will receive a sequence of item and quantity pairs.

Output
---------

Print only the types from which you have items in the bag ordered by Total Amount descending. Inside a type order, the items are first alphabetically in descending order and then by an amount in ascending order. Use the following format for each type:

"<{type}> ${total amount}"

"##{item} - {amount}" - each item on new line

Constraints
--------------

•	Bag’s max capacity will always be a positive number.

•	All quantities will be positive integer in the range [0 … 2100000000].

•	Each item of type gem will have a name - at least 4 symbols.

•	Time limit: 0.1 sec. Memory limit: 16 MB.

**Input:**	

         150
         Gold 28 Rubygem 16 USD 9 GBP 8	<Gold> $28

**Output:**

          ##Gold - 28
          <Gem> $16
          ##Rubygem - 16
          <Cash> $9
          ##USD - 9

**INPUT:**

         2400001
         USD 1030 Gold 300000 EmeraldGem 900000 Topazgem 290000 CHF 280000 Gold 10000000 JPN 10000 Rubygem 10000000 KLM 3120010

**OUTPUT:**

           <Gold> $10300000
           ##Gold - 10300000
           <Gem> $10290000
           ##Topazgem - 290000
           ##Rubygem - 10000000
           <Cash> $3410010
           ##KLM - 3120010
           ##JPN - 10000
           ##CHF - 280000

