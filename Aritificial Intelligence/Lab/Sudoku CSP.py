puzzle = [[5, 3, 0, 0, 7, 0, 0, 0, 0], 
		[6, 0, 0, 1, 9, 5, 0, 0, 0], 
		[0, 9, 8, 0, 0, 0, 0, 6, 0], 
		[8, 0, 0, 0, 6, 0, 0, 0, 3], 
		[4, 0, 0, 8, 0, 3, 0, 0, 1], 
		[7, 0, 0, 0, 2, 0, 0, 0, 6], 
		[0, 6, 0, 0, 0, 0, 2, 8, 0], 
		[0, 0, 0, 4, 1, 9, 0, 0, 5], 
		[0, 0, 0, 0, 8, 0, 0, 0, 0] 
		] 

def print_sudoku(puzzle): 
	for i in range(9): 
		if i % 3 == 0 and i != 0: 
			print("- - - - - - - - - - - ") 
		for j in range(9): 
			if j % 3 == 0 and j != 0: 
				print(" | ", end="") 
			print(puzzle[i][j], end=" ") 
		print() 

print_sudoku(puzzle) 

class CSP: 
	def __init__(self, variables, Domains,constraints): 
		self.variables = variables 
		self.domains = Domains 
		self.constraints = constraints 
		self.solution = None

	def solve(self): 
		assignment = {} 
		self.solution = self.backtrack(assignment) 
		return self.solution 

	def backtrack(self, assignment): 
		if len(assignment) == len(self.variables): 
			return assignment 

		var = self.select_unassigned_variable(assignment) 
		for value in self.order_domain_values(var, assignment): 
			if self.is_consistent(var, value, assignment): 
				assignment[var] = value 
				result = self.backtrack(assignment) 
				if result is not None: 
					return result 
				del assignment[var] 
		return None

	def select_unassigned_variable(self, assignment): 
		unassigned_vars = [var for var in self.variables if var not in assignment] 
		return min(unassigned_vars, key=lambda var: len(self.domains[var])) 

	def order_domain_values(self, var, assignment): 
		return self.domains[var] 

	def is_consistent(self, var, value, assignment): 
		for constraint_var in self.constraints[var]: 
			if constraint_var in assignment and assignment[constraint_var] == value: 
				return False
		return True
	
	
# Variables 
variables = [(i, j) for i in range(9) for j in range(9)] 
# Domains 
Domains = {var: set(range(1, 10)) if puzzle[var[0]][var[1]] == 0
						else {puzzle[var[0]][var[1]]} for var in variables} 

# Add contraint 
def add_constraint(var): 
	constraints[var] = [] 
	for i in range(9): 
		if i != var[0]: 
			constraints[var].append((i, var[1])) 
		if i != var[1]: 
			constraints[var].append((var[0], i)) 
	sub_i, sub_j = var[0] // 3, var[1] // 3
	for i in range(sub_i * 3, (sub_i + 1) * 3): 
		for j in range(sub_j * 3, (sub_j + 1) * 3): 
			if (i, j) != var: 
				constraints[var].append((i, j)) 
# constraints		 
constraints = {} 
for i in range(9): 
	for j in range(9): 
		add_constraint((i, j)) 
		
# Solution 
print('*'*7,'Solution','*'*7) 
csp = CSP(variables, Domains, constraints) 
sol = csp.solve() 

solution = [[0 for i in range(9)] for i in range(9)] 
for i,j in sol: 
	solution[i][j]=sol[i,j] 
	
print_sudoku(solution)
