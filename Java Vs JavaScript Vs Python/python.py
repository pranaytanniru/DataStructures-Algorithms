import time
start_time = time.time()
j=0
for i in range(1000000000):
	j=1
print("Execution time for python %s seconds" % (time.time() - start_time))



# output
# Execution time for python 51.73700022697449 seconds
