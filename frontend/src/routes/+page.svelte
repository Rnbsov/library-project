<script>
	import axios from 'axios';
	import { onMount } from 'svelte';

	let departments = [];
	let editions = [];
	let newDepartment = {
		genreName: 'test',
		libraryId: 1 // Assuming libraryId is 1 for simplicity
	};
	let newEdition = {
		name: '',
		author: '',
		yearOfPublication: '',
		departmentId: ''
	};

	const getDepartments = async () => {
		try {
			const response = await axios.get('http://localhost:8080/departments');
			departments = response.data;
		} catch (error) {
			console.error('Error fetching departments:', error);
		}
	};

	const getEditions = async () => {
		try {
			const response = await axios.get('http://localhost:8080/editions');
			editions = response.data;
		} catch (error) {
			console.error('Error fetching editions:', error);
		}
	};

	const addDepartment = async () => {
		try {
			await axios.post('http://localhost:8080/departments', newDepartment);
			await getDepartments();
			newDepartment.genreName = '';
		} catch (error) {
			console.error('Error adding department:', error);
		}
	};

	const addEdition = async () => {
		try {
			await axios.post('http://localhost:8080/editions', newEdition);
			await getEditions();
			newEdition.name = '';
			newEdition.author = '';
			newEdition.yearOfPublication = '';
			newEdition.departmentId = '';
		} catch (error) {
			console.error('Error adding edition:', error);
		}
	};

	onMount(() => {
		getDepartments();
		getEditions();
	});
</script>

<div class="container">
	<h1>Library Management</h1>

	<h2>Add Department</h2>
	<div class="form-group">
		<label for="genreName">Genre Name</label>
		<input type="text" id="genreName" bind:value={newDepartment.genreName} />
	</div>
	<div class="form-group">
		<button class="bg-amber-400" on:click={addDepartment}>Add Department</button>
	</div>

	<h2>Add Edition</h2>
	<div class="form-group">
		<label for="editionName">Name</label>
		<input type="text" id="editionName" bind:value={newEdition.name} />
	</div>
	<div class="form-group">
		<label for="author">Author</label>
		<input type="text" id="author" bind:value={newEdition.author} />
	</div>
	<div class="form-group">
		<label for="yearOfPublication">Year of Publication</label>
		<input type="number" id="yearOfPublication" bind:value={newEdition.yearOfPublication} />
	</div>
	<div class="form-group">
		<label for="departmentId">Department ID</label>
		<input type="number" id="departmentId" bind:value={newEdition.departmentId} />
	</div>
	<div class="form-group">
		<button on:click={addEdition}>Add Edition</button>
	</div>

	<h2>Departments</h2>
	<div class="list">
		{#each departments as department}
			<div class="list-item">
				<strong>{department.genreName}</strong> (ID: {department.id})
			</div>
		{/each}
	</div>

	<h2>Editions</h2>
	<div class="list">
		{#each editions as edition}
			<div class="list-item">
				<strong>{edition.name}</strong> by {edition.author} (Year: {edition.yearOfPublication},
				Department ID: {edition.departmentId})
			</div>
		{/each}
	</div>
</div>

<style>
	.container {
		max-width: 800px;
		margin: 0 auto;
		padding: 20px;
	}
	.form-group {
		margin-bottom: 15px;
	}
	.form-group label {
		display: block;
		margin-bottom: 5px;
	}
	.form-group input {
		width: 100%;
		padding: 8px;
		box-sizing: border-box;
	}
	.form-group button {
		padding: 10px 15px;
	}
	.list {
		margin-top: 20px;
	}
	.list-item {
		padding: 10px;
		border: 1px solid #ccc;
		margin-bottom: 10px;
	}
</style>
